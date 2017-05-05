package Database;

import Exceptions.InvalidBarCodeException;
import Exceptions.ProductNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {
    Database database;

    @Before
    public void startUp() {
        database = new Database();
        database.add("123", new Product("xxx", "123", 100));
    }

    @Test
    public void getProductTest1() throws Exception {
        Product product = database.getProduct("123");
        assertEquals(product.getName(), "xxx");
        assertEquals(product.getPrice(), 100, 0.01);
    }

    @Test (expected = ProductNotFoundException.class)
    public void getProductTest2() throws Exception {
        Product product = database.getProduct("321");
    }

    @Test (expected = InvalidBarCodeException.class)
    public void getProductTest3() throws Exception {
        Product product = database.getProduct("");
    }

    @Test (expected = InvalidBarCodeException.class)
    public void getProductTest4() throws Exception {
        Product product = database.getProduct(null);
    }
}