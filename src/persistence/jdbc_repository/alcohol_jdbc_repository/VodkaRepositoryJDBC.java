package persistence.jdbc_repository.alcohol_jdbc_repository;

import connection.DatabaseConnection;
import domain.products.alcohol.Vodka;
import persistence.jdbc_repository.StatementsJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class VodkaRepositoryJDBC extends StatementsJDBC {
    private static VodkaRepositoryJDBC instance;

    private static final String INSERT_STATEMENT = "INSERT INTO alcoholProducts (alcoholPercentage, alcoholType, uniqueID) VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM alcoholProducts WHERE uniqueID = ?";
    private static final String UPDATE_STATEMENT = "UPDATE alcoholProducts SET alcoholPercentage = ?, alcoholType = ? WHERE uniqueID = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM alcoholProducts WHERE uniqueID = ?";

    private VodkaRepositoryJDBC() {
    }

    public static VodkaRepositoryJDBC getInstance() {
        if (instance == null) {
            instance = new VodkaRepositoryJDBC();
        }

        return instance;
    }

    public Vodka save(Vodka vodka) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_PL)) {
            statement.setDouble(1, vodka.getPrice());
            statement.setString(2, vodka.getName());
            statement.setString(3, vodka.getOriginCountry());
            statement.setString(4, vodka.getIngredients());
            statement.setString(5, vodka.getProductType());
            statement.setString(6, vodka.getId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product label was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a product label Vodka: " + e.getMessage());
            return new Vodka();
        }

        try (PreparedStatement statement2 = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement2.setDouble(1, vodka.getAlcoholPercentage());
            statement2.setString(2, vodka.getAlcoholType());
            statement2.setString(3, vodka.getId());


            int rowsInserted = statement2.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Vodka was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new Vodka: " + e.getMessage());
            return new Vodka();
        }
        return vodka;
    }

    public Vodka find(Vodka vodkaFind) {
        Vodka vodka = new Vodka();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL_ALL)) {
            statement.setDouble(1, vodkaFind.getPrice());
            statement.setString(2, vodkaFind.getName());
            statement.setString(3, vodkaFind.getOriginCountry());
            statement.setString(4, vodkaFind.getIngredients());
            statement.setString(5, vodkaFind.getProductType());

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Vodka name: Vodka name was not found!");
                    return vodka;
                }

                System.out.println("Beer name was found!");

                vodka.setPrice(result.getDouble("price"));
                vodka.setName(result.getString("name"));
                vodka.setOriginCountry(result.getString("originCountry"));
                vodka.setIngredients(result.getString("ingredients"));
                vodka.setProductType(result.getString("productType"));
                vodka.setId(result.getString("uniqueID"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Vodka name: " + e.getMessage());
            return vodka;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Vodka name: Vodka name was not found!");
                    return vodka;
                }

                System.out.println("Vodka was found!");
                vodka.setAlcoholPercentage(result.getInt("alcoholPercentage"));
                vodka.setAlcoholType();
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Vodka name: " + e.getMessage());
            return vodka;
        }

        return vodka;
    }

    public Vodka findName(String name) {
        Vodka vodka = new Vodka();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL)) {
            statement.setString(1, name);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Vodka name: Vodka name was not found!");
                    return vodka;
                }

                System.out.println("Beer name was found!");

                vodka.setPrice(result.getDouble("price"));
                vodka.setName(result.getString("name"));
                vodka.setOriginCountry(result.getString("originCountry"));
                vodka.setIngredients(result.getString("ingredients"));
                vodka.setProductType(result.getString("productType"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Vodka name: " + e.getMessage());
            return vodka;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Vodka name: Vodka name was not found!");
                    return vodka;
                }

                System.out.println("Vodka was found!");
                vodka.setAlcoholPercentage(result.getInt("alcoholPercentage"));
                vodka.setAlcoholType();
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Vodka name: " + e.getMessage());
            return vodka;
        }

        return vodka;
    }

    public Vodka update(Vodka oldProduct, Vodka newProduct) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT_PL)) {
            statement.setDouble(1, newProduct.getPrice());
            statement.setString(2, newProduct.getName());
            statement.setString(3, newProduct.getOriginCountry());
            statement.setString(4, newProduct.getIngredients());
            statement.setString(5, newProduct.getProductType());
            statement.setString(6, oldProduct.getId());

            statement.setDouble(7, oldProduct.getPrice());
            statement.setString(8, oldProduct.getName());
            statement.setString(9, oldProduct.getOriginCountry());
            statement.setString(10, oldProduct.getIngredients());
            statement.setString(11, oldProduct.getProductType());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Vodka product label was updated successfully!");
                return newProduct;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Vodka product label: " + e.getMessage());
            return new Vodka();
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, newProduct.getAlcoholPercentage());
            statement.setString(2, newProduct.getAlcoholType());
            statement.setString(3, oldProduct.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Vodka was updated successfully!");
                return newProduct;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Vodka: " + e.getMessage());
            return new Vodka();
        }

        System.out.println("Something went wrong when trying to update Vodka: Vodka was not found!");
        return new Vodka();
    }

    public boolean delete(Vodka vodka) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT_PL)) {
            statement.setString(1, vodka.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Vodka product label was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete Vodka product label: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete Vodka product label: Vodka product label was not found!");
        return false;
    }
}
