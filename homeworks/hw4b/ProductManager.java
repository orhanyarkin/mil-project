package hw4b;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private Connection connection;

    public ProductManager() throws SQLException {
        String url = "jdbc:postgresql://localhost/orhan";
        String user = "postgres";
        String password = "190307";
        String driver = "org.postgresql.Driver";
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public boolean insert(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"products\" (pname, pprice, pdescription) VALUES (?, ?, ?)");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE \"products\" SET pname=?, pprice=?, pdescription=? WHERE pid=?");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setLong(4, product.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(long productId) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"products\" WHERE pid=?");
            statement.setLong(1, productId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Product find(long productId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"products\" WHERE pid=?");
            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("pname");
                double price = resultSet.getDouble("pprice");
                String description = resultSet.getString("pdescription");
                return new Product(productId, name, price, description);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> findAll() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"products\"");
            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("pid");
                String name = resultSet.getString("pname");
                double price = resultSet.getDouble("pprice");
                String description = resultSet.getString("pdescription");
                products.add(new Product(id, name, price, description));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
