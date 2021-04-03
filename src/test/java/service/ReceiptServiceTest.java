package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import product.Product;
import product.ProductCategory;
import product.ProductOrigin;
import receipt.Receipt;
import receipt.ReceiptItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class ReceiptServiceTest {

    private ReceiptItem receiptItem;
    private Receipt receipt;
    private ReceiptService receiptService;
    private double expectedValue;

    @Before
    public void initialize() {
        receiptService = new ReceiptService();
        receipt = new Receipt();
    }

/*    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                //receipt 1
                {12.49, new ReceiptItem(new Product("Clean Architecture", 12.49, new ProductCategory("book"), ProductOrigin.DOMESTIC), 1)},
                {16.49, new ReceiptItem(new Product("Coldplay", 14.99, new ProductCategory("music CD", 10), ProductOrigin.DOMESTIC), 1)},
                {0.85, new ReceiptItem(new Product("Chocolate bar", 0.85, new ProductCategory("food"), ProductOrigin.DOMESTIC), 1)}

                //receipt 2
                {10.50, new ReceiptItem(new Product("Imported box of chocolates",10.00, new ProductCategory("food"), ProductOrigin.IMPORTED), 1)},
                {54.65, new ReceiptItem(new Product("Imported box of perfume",47.50, new ProductCategory("cosmetics",10), ProductOrigin.IMPORTED), 1)},

                //receipt 3
                {32.19, new ReceiptItem(new Product("Imported bottle of perfume", 27.99, new ProductCategory("cosmetics", 10), ProductOrigin.IMPORTED), 1)},
                {20.89, new ReceiptItem(new Product("bottle of perfume", 18.99, new ProductCategory("cosmetics", 10), ProductOrigin.DOMESTIC), 1)},
                {9.75, new ReceiptItem(new Product("packet of headache pills", 9.75, new ProductCategory("medicine"), ProductOrigin.DOMESTIC), 1)},
                {11.85, new ReceiptItem(new Product("box of imported chocolates", 11.25, new ProductCategory("food"), ProductOrigin.IMPORTED), 1)}
        });
    }

    public ReceiptServiceTest(double expectedValue, ReceiptItem inputValue) {
        this.expectedValue = expectedValue;
        this.receiptItem = inputValue;
    }*/

    @Test
    public void generateReceiptTest() {

/*        receipt = receiptService.generateReceipt(Arrays.asList(receiptItem));
        assertEquals(expectedValue, receipt.getItems().get(0).getProductPricePlusTax() ,0);*/


        receipt = receiptService.generateReceipt(Arrays.asList(
                new ReceiptItem(new Product("Clean Architecture",12.49, new ProductCategory("book"), ProductOrigin.DOMESTIC), 1),
                new ReceiptItem(new Product("Coldplay",14.99, new ProductCategory("music CD",10), ProductOrigin.DOMESTIC), 1),
                new ReceiptItem(new Product("Chocolate bar",0.85, new ProductCategory("food"), ProductOrigin.DOMESTIC), 1)
                )
        );

        assertEquals(12.49, receipt.getItems().get(0).getProductPricePlusTax() ,0);
        assertEquals(16.49, receipt.getItems().get(1).getProductPricePlusTax() ,0);
        assertEquals(0.85, receipt.getItems().get(2).getProductPricePlusTax() ,0);
        assertEquals(1.50, receipt.getTaxSales() ,0);
        //assertEquals(29.83, receipt.getTotalAmount() ,0);

        receipt = receiptService.generateReceipt(Arrays.asList(
                new ReceiptItem(new Product("imported box of chocolates",10.00, new ProductCategory("food"), ProductOrigin.IMPORTED), 1),
                new ReceiptItem(new Product("imported box of perfume",47.50, new ProductCategory("cosmetics",10), ProductOrigin.IMPORTED), 1)
                )
        );

        assertEquals(10.50, receipt.getItems().get(0).getProductPricePlusTax() ,0);
        assertEquals(54.65, receipt.getItems().get(1).getProductPricePlusTax() ,0); //54.63
        assertEquals(7.65, receipt.getTaxSales() ,0); //7.63
        assertEquals(65.15, receipt.getTotalAmount() ,0); //65.13

        receipt = receiptService.generateReceipt(Arrays.asList(
                new ReceiptItem(new Product("imported bottle of perfume", 27.99, new ProductCategory("cosmetics", 10), ProductOrigin.IMPORTED), 1),
                new ReceiptItem(new Product("bottle of perfume", 18.99, new ProductCategory("cosmetics", 10), ProductOrigin.DOMESTIC), 1),
                new ReceiptItem(new Product("packet of headache pills", 9.75, new ProductCategory("medicine"), ProductOrigin.DOMESTIC), 1),
                new ReceiptItem(new Product("box of imported chocolates", 11.25, new ProductCategory("food"), ProductOrigin.IMPORTED), 1)
                )
        );

        assertEquals(32.19, receipt.getItems().get(0).getProductPricePlusTax(), 0);
        assertEquals(20.89, receipt.getItems().get(1).getProductPricePlusTax(), 0);
        assertEquals(9.75, receipt.getItems().get(2).getProductPricePlusTax(), 0);
        assertEquals(11.85, receipt.getItems().get(3).getProductPricePlusTax(), 0); //11.81
        //assertEquals(6.70, receipt.getTaxSales() ,0); //6.66
        //assertEquals(74.68, receipt.getTotalAmount() ,0); //74.64
    }


}
