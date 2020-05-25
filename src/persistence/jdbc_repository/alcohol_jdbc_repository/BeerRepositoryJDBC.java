package persistence.jdbc_repository.alcohol_jdbc_repository;

import connection.DatabaseConnection;
import domain.products.alcohol.Beer;
import persistence.jdbc_repository.StatementsJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class BeerRepositoryJDBC extends StatementsJDBC {
    private static BeerRepositoryJDBC instance;

    private static final String INSERT_STATEMENT = "INSERT INTO alcoholProducts (alcoholPercentage, alcoholType, uniqueID) VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM alcoholProducts WHERE uniqueID = ?";
    private static final String UPDATE_STATEMENT = "UPDATE alcoholProducts SET alcoholPercentage = ?, alcoholType = ? WHERE uniqueID = ?";

    private BeerRepositoryJDBC() {
    }

    public static BeerRepositoryJDBC getInstance() {
        if (instance == null) {
            instance = new BeerRepositoryJDBC();
        }

        return instance;
    }

    public Beer save(Beer beer) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_PL)) {
            statement.setDouble(1, beer.getPrice());
            statement.setString(2, beer.getName());
            statement.setString(3, beer.getOriginCountry());
            statement.setString(4, beer.getIngredients());
            statement.setString(5, beer.getProductType());
            statement.setString(6, beer.getId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product label was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a product label beer: " + e.getMessage());
            return new Beer();
        }

        try (PreparedStatement statement2 = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement2.setDouble(1, beer.getAlcoholPercentage());
            statement2.setString(2, beer.getAlcoholType());
            statement2.setString(3, beer.getId());


            int rowsInserted = statement2.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new beer was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new beer: " + e.getMessage());
            return new Beer();
        }
        return beer;
    }

    public Beer find(Beer beerFind) {
        Beer beer = new Beer();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL_ALL)) {
            statement.setDouble(1, beerFind.getPrice());
            statement.setString(2, beerFind.getName());
            statement.setString(3, beerFind.getOriginCountry());
            statement.setString(4, beerFind.getIngredients());
            statement.setString(5, beerFind.getProductType());

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find beer name: beer name was not found!");
                    return beer;
                }

                System.out.println("Beer name was found!");

                beer.setPrice(result.getDouble("price"));
                beer.setName(result.getString("name"));
                beer.setOriginCountry(result.getString("originCountry"));
                beer.setIngredients(result.getString("ingredients"));
                beer.setProductType(result.getString("productType"));
                beer.setId(result.getString("uniqueID"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find beer name: " + e.getMessage());
            return beer;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find beer name: beer name was not found!");
                    return beer;
                }

                System.out.println("Beer was found!");
                beer.setAlcoholPercentage(result.getInt("alcoholPercentage"));
                beer.setAlcoholType();
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find beer name: " + e.getMessage());
            return beer;
        }

        return beer;
    }

    public Beer findName(String name) {
        Beer beer = new Beer();
        String ID = "";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT_PL)) {
            statement.setString(1, name);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find beer name: beer name was not found!");
                    return beer;
                }

                System.out.println("Beer name was found!");

                beer.setPrice(result.getDouble("price"));
                beer.setName(result.getString("name"));
                beer.setOriginCountry(result.getString("originCountry"));
                beer.setIngredients(result.getString("ingredients"));
                beer.setProductType(result.getString("productType"));
                beer.setId(result.getString("uniqueID"));

                ID = result.getString("uniqueID");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find beer name: " + e.getMessage());
            return beer;
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, ID);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find beer name: beer name was not found!");
                    return beer;
                }

                System.out.println("Beer was found!");
                beer.setAlcoholPercentage(result.getInt("alcoholPercentage"));
                beer.setAlcoholType();
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find beer name: " + e.getMessage());
            return beer;
        }

        return beer;
    }

    public Beer update(Beer oldBeer, Beer newBeer) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT_PL)) {
            statement.setDouble(1, newBeer.getPrice());
            statement.setString(2, newBeer.getName());
            statement.setString(3, newBeer.getOriginCountry());
            statement.setString(4, newBeer.getIngredients());
            statement.setString(5, newBeer.getProductType());
            statement.setString(6, oldBeer.getId());

            statement.setDouble(7, oldBeer.getPrice());
            statement.setString(8, oldBeer.getName());
            statement.setString(9, oldBeer.getOriginCountry());
            statement.setString(10, oldBeer.getIngredients());
            statement.setString(11, oldBeer.getProductType());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Beer product label was updated successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update Beer product label: " + e.getMessage());
            return new Beer();
        }

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, newBeer.getAlcoholPercentage());
            statement.setString(2, newBeer.getAlcoholType());
            statement.setString(3, oldBeer.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Beer was updated successfully!");
                return newBeer;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update beer: " + e.getMessage());
            return new Beer();
        }

        System.out.println("Something went wrong when trying to update beer: Beer was not found!");
        return new Beer();
    }

    public boolean delete(Beer beer) {
        System.out.println(beer.getId());
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT_PL)) {
            statement.setString(1, beer.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Beer product label was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete beer product label: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete beer product label: beer product label was not found!");
        return false;
    }
}
