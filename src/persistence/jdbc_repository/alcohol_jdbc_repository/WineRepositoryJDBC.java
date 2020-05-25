package persistence.jdbc_repository.alcohol_jdbc_repository;

import connection.DatabaseConnection;
import domain.products.alcohol.Wine;
import persistence.jdbc_repository.StatementsJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class WineRepositoryJDBC extends StatementsJDBC {
    private static WineRepositoryJDBC instance;

    private static final String INSERT_STATEMENT = "INSERT INTO alcoholProducts (alcoholPercentage, alcoholType, uniqueID) VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM alcoholProducts WHERE uniqueID = ?";
    private static final String UPDATE_STATEMENT = "UPDATE alcoholProducts SET alcoholPercentage = ?, alcoholType = ? WHERE uniqueID = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM alcoholProducts WHERE uniqueID = ?";

    private WineRepositoryJDBC() {
    }

    public static WineRepositoryJDBC getInstance() {
        if (instance == null) {
            instance = new WineRepositoryJDBC();
        }

        return instance;
    }

    public Wine save(Wine wine) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_PL)) {
            statement.setDouble(1, wine.getPrice());
            statement.setString(2, wine.getName());
            statement.setString(3, wine.getOriginCountry());
            statement.setString(4, wine.getIngredients());
            statement.setString(5, wine.getProductType());
            statement.setString(6, wine.getId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product label was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a product label Wine: " + e.getMessage());
            return new Wine();
        }

        try (PreparedStatement statement2 = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement2.setDouble(1, wine.getAlcoholPercentage());
            statement2.setString(2, wine.getAlcoholType());
            statement2.setString(3, wine.getId());


            int rowsInserted = statement2.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Wine was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new Wine: " + e.getMessage());
            return new Wine();
        }
        return wine;
    }

    public Wine find(Wine wineFind) {
        Wine wine = new Wine();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL_ALL)) {
            statement.setDouble(1, wineFind.getPrice());
            statement.setString(2, wineFind.getName());
            statement.setString(3, wineFind.getOriginCountry());
            statement.setString(4, wineFind.getIngredients());
            statement.setString(5, wineFind.getProductType());

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Wine name: Wine name was not found!");
                    return wine;
                }

                System.out.println("Beer name was found!");

                wine.setPrice(result.getDouble("price"));
                wine.setName(result.getString("name"));
                wine.setOriginCountry(result.getString("originCountry"));
                wine.setIngredients(result.getString("ingredients"));
                wine.setProductType(result.getString("productType"));
                wine.setId(result.getString("uniqueID"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Wine name: " + e.getMessage());
            return wine;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Wine name: Wine name was not found!");
                    return wine;
                }

                System.out.println("Wine was found!");
                wine.setAlcoholPercentage(result.getInt("alcoholPercentage"));
                wine.setAlcoholType();
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Wine name: " + e.getMessage());
            return wine;
        }

        return wine;
    }

    public Wine findName(String name) {
        Wine wine = new Wine();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL)) {
            statement.setString(1, name);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Wine name: Wine name was not found!");
                    return wine;
                }

                System.out.println("Beer name was found!");

                wine.setPrice(result.getDouble("price"));
                wine.setName(result.getString("name"));
                wine.setOriginCountry(result.getString("originCountry"));
                wine.setIngredients(result.getString("ingredients"));
                wine.setProductType(result.getString("productType"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Wine name: " + e.getMessage());
            return wine;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Wine name: Wine name was not found!");
                    return wine;
                }

                System.out.println("Wine was found!");
                wine.setAlcoholPercentage(result.getInt("alcoholPercentage"));
                wine.setAlcoholType();
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Wine name: " + e.getMessage());
            return wine;
        }

        return wine;
    }

    public Wine update(Wine oldProduct, Wine newProduct) {
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
                System.out.println("Wine product label was updated successfully!");
                return newProduct;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Wine product label: " + e.getMessage());
            return new Wine();
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, newProduct.getAlcoholPercentage());
            statement.setString(2, newProduct.getAlcoholType());
            statement.setString(3, oldProduct.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Wine was updated successfully!");
                return newProduct;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Wine: " + e.getMessage());
            return new Wine();
        }

        System.out.println("Something went wrong when trying to update Wine: Wine was not found!");
        return new Wine();
    }

    public boolean delete(Wine wine) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT_PL)) {
            statement.setString(1, wine.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Wine product label was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete Wine product label: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete Wine product label: Wine product label was not found!");
        return false;
    }
}
