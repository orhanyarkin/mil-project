package hw4b;

public class InsertTest {

    public static void main(String[] args) throws Exception {
        ProductManager manager = new ProductManager();
        Product product = new Product("orhan", 100.0, "yeni");
        boolean success = manager.insert(product);
        if (success) {
            System.out.println("Product inserted successfully.");
        } else {
            System.out.println("Failed to insert product.");
        }
    }
}