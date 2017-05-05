package Database;

import Exceptions.InvalidBarCodeException;
import Exceptions.ProductNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, Product> products;

    public Database() {
        products = new HashMap<String, Product>();
    }

    public void add(String key, Product product) {
        products.put(key, product);
    }

    public Product getProduct(String barCode) throws Exception {
        if (barCode == null || barCode.isEmpty()) {
            throw new InvalidBarCodeException("Invalid bar-code");
        }
        else if (!products.containsKey(barCode)) {
            throw new ProductNotFoundException("Database.Product not found");
        }
        else {
            Product product = products.get(barCode);
            return product;
        }
    }
}
