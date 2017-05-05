package Output;

import Database.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Printer {
    public void printReceipt(List<Product> receipt, double totalSum) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File("receipt.txt")));
            for (Product product : receipt) {
                writer.write(product.getName() + "\t\t" + product.getPrice());
                writer.newLine();
            }
            writer.write("------------------------------------------");
            writer.newLine();
            writer.write("TOTAL SUM:\t\t" + totalSum);
        } catch (Exception e) {
            System.out.println("PRINTER HAS BROKEN");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("PRINTER HAS BROKEN");
            }
        }
    }
}
