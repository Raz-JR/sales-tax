package product;

import java.util.Optional;

public class Product {

    private int id;
    private String name;
    private double price;
    private ProductCategory category;
    private ProductOrigin origin;

    public Product(String name, double price, ProductCategory category, ProductOrigin origin) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.origin = origin;
    }

    public Product(String name, double price) {
        this(name,price,null,ProductOrigin.DOMESTIC);
    }

    public ProductOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(ProductOrigin origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Optional<ProductCategory> getCategory() {
        return Optional.of(category);
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

}
