package hw3b;

class ProductFormat {
    public static void formatProduct(Product product) {
        System.out.printf("Ad: %s - Fiyat: %.2f - Kategori: %s", product.getName(), product.getPrice(), product.getCategory());
    }
}

