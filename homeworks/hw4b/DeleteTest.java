package hw4b;
public class DeleteTest {

    public static void main(String[] args) throws Exception {
        ProductManager manager = new ProductManager();
        boolean success = manager.delete(1);
        if (success) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Failed to delete product.");
        }
    }
}

