package Database;

public class Product {
    private String name;
    private String barCode;
    private double price;

    public Product(String name, String barCode, double price) {
        this.name = name;
        this.barCode = barCode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
