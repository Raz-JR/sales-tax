package service;

import org.apache.log4j.Logger;
import receipt.Receipt;
import receipt.ReceiptItem;

public class ConsoleService {

    public static void printConsoleReceipt(Receipt receipt){
        double taxSales = receipt.getTaxSales();
        double totalAmount = receipt.getTotalAmount();

        for (ReceiptItem item: receipt.getItems()) {
            System.out.println(item.getNumberOfItem() + " " + item.getProduct().getName() + " at " + item.getProductPricePlusTax());
        }
        System.out.println("Sales Taxes: " + taxSales + " Total: " + totalAmount);
        System.out.println("----------------------");
    }
}
