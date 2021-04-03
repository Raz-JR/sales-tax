package receipt;

import java.util.List;

public class Receipt {

    private int id;
    private List<ReceiptItem> items;
    private double taxSales;
    private double totalAmount;

    public Receipt(List<ReceiptItem> items, double taxSales, double totalAmount) {
        this.items = items;
        this.taxSales = taxSales;
        this.totalAmount = totalAmount;
    }

    public Receipt() {}

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTaxSales() {
        return taxSales;
    }

    public void setTaxSales(double taxSales) {
        this.taxSales = taxSales;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }
}
