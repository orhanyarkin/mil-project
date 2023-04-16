package hw3a;
public class ProductConverter {
        public String format(Product product) {
            return product.getProductId() + "," + product.getProductName() + "," + product.getSalesPrice();
        }
        public Product parse(String line) {
            String[] tokens = line.split(",");
            int productId = Integer.parseInt(tokens[0]);
            String productName = tokens[1];
            double salesPrice = Double.parseDouble(tokens[2]);
            return new Product(productId, productName, salesPrice);
        }
    }

