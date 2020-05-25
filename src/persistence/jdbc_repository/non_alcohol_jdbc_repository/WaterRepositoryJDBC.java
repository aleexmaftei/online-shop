package persistence.jdbc_repository.non_alcohol_jdbc_repository;

import connection.DatabaseConnection;
import domain.products.non_alcohol.Water;
import persistence.jdbc_repository.StatementsJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class WaterRepositoryJDBC extends StatementsJDBC {
    private static WaterRepositoryJDBC instance;

    private static final String INSERT_STATEMENT = "INSERT INTO nonAlcoholProducts (type,  uniqueID) VALUES (?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM nonAlcoholProducts WHERE uniqueID = ?";
    private static final String UPDATE_STATEMENT = "UPDATE nonAlcoholProducts SET type = ? WHERE uniqueID = ?";

    private WaterRepositoryJDBC() {
    }

    public static WaterRepositoryJDBC getInstance() {
        if (instance == null) {
            instance = new WaterRepositoryJDBC();
        }

        return instance;
    }

    public Water save(Water water) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_PL)) {
            statement.setDouble(1, water.getPrice());
            statement.setString(2, water.getName());
            statement.setString(3, water.getOriginCountry());
            statement.setString(4, water.getIngredients());
            statement.setString(5, water.getProductType());
            statement.setString(6, water.getId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product label was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a product label Water: " + e.getMessage());
            return new Water();
        }

        try (PreparedStatement statement2 = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement2.setString(1, "Water");
            statement2.setString(2, water.getId());


            int rowsInserted = statement2.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Wine was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new Water: " + e.getMessage());
            return new Water();
        }
        return water;
    }

    public Water find(Water waterFind) {
        Water water = new Water();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL_ALL)) {
            statement.setDouble(1, waterFind.getPrice());
            statement.setString(2, waterFind.getName());
            statement.setString(3, waterFind.getOriginCountry());
            statement.setString(4, waterFind.getIngredients());
            statement.setString(5, waterFind.getProductType());

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Water name: Water name was not found!");
                    return water;
                }

                System.out.println("Water name was found!");

                water.setPrice(result.getDouble("price"));
                water.setName(result.getString("name"));
                water.setOriginCountry(result.getString("originCountry"));
                water.setIngredients(result.getString("ingredients"));
                water.setProductType(result.getString("productType"));
                water.setId(result.getString("uniqueID"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Water name: " + e.getMessage());
            return water;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Water name: Water name was not found!");
                    return water;
                }

                System.out.println("Water was found!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Water name: " + e.getMessage());
            return water;
        }

        return water;
    }

    public Water findName(String name) {
        Water water = new Water();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL)) {
            statement.setString(1, name);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Water name: Water name was not found!");
                    return water;
                }

                System.out.println("Water name was found!");

                water.setPrice(result.getDouble("price"));
                water.setName(result.getString("name"));
                water.setOriginCountry(result.getString("originCountry"));
                water.setIngredients(result.getString("ingredients"));
                water.setProductType(result.getString("productType"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Water name: " + e.getMessage());
            return water;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find Water name: Water name was not found!");
                    return water;
                }

                System.out.println("Water was found!");

            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find Water name: " + e.getMessage());
            return water;
        }

        return water;
    }

    public Water update(Water oldProduct, Water newProduct) {
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
                System.out.println("Water product label was updated successfully!");
                return newProduct;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Water product label: " + e.getMessage());
            return new Water();
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, "Water");
            statement.setString(2, oldProduct.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Water was updated successfully!");
                return newProduct;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Water: " + e.getMessage());
            return new Water();
        }

        System.out.println("Something went wrong when trying to update Water: Water was not found!");
        return new Water();
    }

    public boolean delete(Water water) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT_PL)) {
            statement.setString(1, water.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Water product label was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete Water product label: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete Water product label: Water product label was not found!");
        return false;
    }
}
