package hw3a;

public class ConverterTest {
    public static void main(String[] args) {
        Product product = new Product(1, "Orhan", 15);
        ProductConverter converter = new ProductConverter();
        String productStr = converter.format(product);
        System.out.println(productStr);
        Product parsedProduct = converter.parse(productStr);
        System.out.println(parsedProduct.getProductId());
        System.out.println(parsedProduct.getProductName());
        System.out.println(parsedProduct.getSalesPrice());
    }
}
