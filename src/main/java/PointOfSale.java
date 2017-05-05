import Database.Database;
import Input.BarCodesScanner;
import Output.LCDDisplay;
import Output.Printer;
import Database.ShoppingList;
import Database.DBLoader;
import Database.Product;

public class PointOfSale {
    private LCDDisplay lcdDisplay;
    private BarCodesScanner barCodesScanner;
    private Printer printer;
    private Database database;
    private ShoppingList shoppingList;

    public PointOfSale () {
        lcdDisplay = new LCDDisplay();
        barCodesScanner = new BarCodesScanner();
        printer = new Printer();
        database = new Database();
        DBLoader.load(database);
    }

    private String scan() {
        String barCode="";
        try {
            barCode = barCodesScanner.scanBarCode();
        } catch (Exception e) { System.out.println("BARCODE SCANNER HAS BROKEN"); }
        return barCode;
    }

    private void addProduct(String barCode) {
        try {
            Product product = database.getProduct(barCode);
            lcdDisplay.display(product.getName() + "\t\t" + product.getPrice());
            shoppingList.add(product);
        } catch(Exception e) {
            lcdDisplay.display(e.getMessage());
        }
    }

    public void start() {
        while(true) {
            shoppingList = new ShoppingList();
            boolean end = false;
            String barCode;
            while(!end) {
                barCode = scan();
                if (barCode.equals("exit")) end = true;
                else {
                    addProduct(barCode);
                }
            }
            printer.printReceipt(shoppingList.getList(), shoppingList.getTotalSum());
            lcdDisplay.display("TOTAL:\t\t" + shoppingList.getTotalSum());
        }
    }
}
