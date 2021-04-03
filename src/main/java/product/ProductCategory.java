package product;

public class ProductCategory {
    private int id;
    private String name;
    private int domesticTaxRate;
    // default    -> 0
    // exception1 -> %2
    // exception2 -> %3.5

    public ProductCategory(String name){
       this(name, 0);
    }

    public ProductCategory(String name, int domesticTaxRate) {
        this.name = name;
        this.domesticTaxRate = domesticTaxRate;
    }

    public int getDomesticTaxRate() {
        return domesticTaxRate;
    }

    public void setDomesticTaxRate(int domesticTaxRate) {
        this.domesticTaxRate = domesticTaxRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
