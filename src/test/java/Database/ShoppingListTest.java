package Database;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingListTest {
    @Test
    public void addtest() throws Exception {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.add(new Product("xxx", "xxx", 1000));
        shoppingList.add(new Product("xxx", "xxx", 100));
        shoppingList.add(new Product("xxx", "xxx", 0.001));
        assertEquals(shoppingList.getTotalSum(), 1100.001, 0.01);
    }
}