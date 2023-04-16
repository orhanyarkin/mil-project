package hw4b;
public class FindTest {

    public static void main(String[] args) throws Exception {
        ProductManager manager = new ProductManager();
        Product product = manager.find(2);
        if (product != null) {
            System.out.println("Product found: " + product.getName() + ", " + product.getPrice() + ", " + product.getDescription());
        } else {
            System.out.println("Product not found.");
        }
    }
}

