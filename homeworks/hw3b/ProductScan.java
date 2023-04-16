package hw3b;

import java.util.Scanner;

public class ProductScan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Category: ");
        scanner.nextLine();
        String category = scanner.nextLine();

        Product product = new Product(name, price, category);

        System.out.println("Readed Product: " + product.getName() + " , " + product.getPrice() + " , " + product.getCategory());

        ProductFormat.formatProduct(product);
    }
}