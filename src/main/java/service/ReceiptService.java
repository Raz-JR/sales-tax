package service;

import org.apache.log4j.Logger;
import product.Product;
import product.ProductOrigin;
import receipt.Receipt;
import receipt.ReceiptItem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Properties;

public class ReceiptService {

    private static final Logger LOGGER = Logger.getLogger(ReceiptService.class);

    int defaultDomesticTaxRate;
    int importedTaxRate;
    boolean isConfigRead = false;

    public void initiate() {
        if (!isConfigRead) {
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (input != null) {
                    Properties properties = new Properties();
                    properties.load(input);
                    importedTaxRate = Integer.parseInt(properties.getProperty("taxes.imported.rate.percent"));
                    defaultDomesticTaxRate = Integer.parseInt(properties.getProperty("taxes.domestic.rate.percent.default"));
                    isConfigRead = true;
                }
            } catch (FileNotFoundException e) {
                LOGGER.error("initialization error : File Not Found :" + e.getMessage());
            } catch (IOException e) {
                LOGGER.error("initialization error : I/O Exception :" + e.getMessage());
            }
        }
    }

    public Receipt generateReceipt(List<ReceiptItem> receiptItems) {
        double salesTax = 0;
        double totalAmount = 0;
        for (ReceiptItem item : receiptItems) {
            double itemTax = item.getNumberOfItem() * calculateTax(item.getProduct());
            salesTax += roundUp(itemTax,2);
            item.setProductPricePlusTax(roundUp(itemTax + item.getProduct().getPrice(), 2));
            totalAmount += item.getProductPricePlusTax();
        }
        Receipt receipt = new Receipt(receiptItems, roundUp(salesTax, 2), roundUp(totalAmount,2));
        ConsoleService.printConsoleReceipt(receipt);
        return receipt;
    }

    private double calculateTax(Product item) {
        initiate();
        int baseTax = item.getCategory().isPresent() ? item.getCategory().get().getDomesticTaxRate() : defaultDomesticTaxRate;
        if (ProductOrigin.IMPORTED.equals(item.getOrigin())) {
            baseTax += importedTaxRate;
        }
        return item.getPrice() * (baseTax / 100D);
    }

    public double roundUp(double value, int places) {

        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        double output = bd.doubleValue();

        //Must change
        int fractionPart = Integer.parseInt((String.valueOf(bd.subtract(new BigDecimal(bd.intValue())))).substring(2));
        if (fractionPart % 10 < 5 && fractionPart % 10 != 0 && fractionPart < 100){
            int roundedValue = Integer.valueOf(String.valueOf(fractionPart / 10) + "5");
            output = Double.parseDouble(String.valueOf(bd.intValue() + "." + roundedValue));
        }
        return output;
    }


}
