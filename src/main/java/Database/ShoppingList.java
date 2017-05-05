package Database;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<Product> list;
    private double totalSum;

    public ShoppingList() {
        list = new ArrayList<Product>();
        totalSum = 0;
    }

    public void add(Product product) {
        list.add(product);
        totalSum += product.getPrice();
    }

    public List<Product> getList() {
        return list;
    }

    public double getTotalSum() {
        return totalSum;
    }
}
