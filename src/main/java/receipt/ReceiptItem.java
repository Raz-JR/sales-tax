package receipt;

import product.Product;

public class ReceiptItem {

    private int id;
    private Product product;
    private int numberOfItem = 1;
    private double productPricePlusTax;

    public ReceiptItem(Product product, int numberOfItem) {
        this.product = product;
        this.numberOfItem = numberOfItem;
    }

    public double getProductPricePlusTax() {
        return productPricePlusTax;
    }

    public void setProductPricePlusTax(double productPricePlusTax) {
        this.productPricePlusTax = productPricePlusTax;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

}
