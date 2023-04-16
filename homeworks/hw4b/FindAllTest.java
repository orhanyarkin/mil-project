package hw4b;

import java.util.List;

public class FindAllTest {

    public static void main(String[] args) throws Exception {
        ProductManager manager = new ProductManager();
        List<Product> products = manager.findAll();
        if (products != null) {
            for (Product product : products) {
                System.out.println(product.getId() + ", " + product.getName() + ", " + product.getPrice() + ", " + product.getDescription());
            }
        } else {
            System.out.println("No products found.");
        }
    }
}
