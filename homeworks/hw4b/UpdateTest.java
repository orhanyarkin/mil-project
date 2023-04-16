package hw4b;
public class UpdateTest {

    public static void main(String[] args) throws Exception {
        ProductManager manager = new ProductManager();
        Product product = manager.find(1);
        if (product != null) {
            product.setPrice(200.0);
            boolean success = manager.update(product);
            if (success) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Failed to update product.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }
}
