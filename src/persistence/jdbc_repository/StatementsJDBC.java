package persistence.jdbc_repository;

public class StatementsJDBC {

    // statements for product label table
    protected static final String INSERT_STATEMENT_PL = "INSERT INTO productLabel (price, name, originCountry, ingredients, productType, uniqueID) VALUES (?, ?, ?, ?, ?, ?)";
    protected static final String SELECT_STATEMENT_PL = "SELECT * FROM productLabel WHERE name = ?";
    protected static final String SELECT_STATEMENT_PL_ALL = "SELECT * FROM productLabel WHERE price = ? AND name = ? AND originCountry = ? AND ingredients = ? AND productType = ?";
    protected static final String UPDATE_STATEMENT_PL = "UPDATE productLabel SET price = ?, name = ?, originCountry = ?, ingredients = ?, productType = ?, uniqueID = ? " +
            "                                            WHERE price = ? AND name = ? AND originCountry = ? AND ingredients = ? AND productType = ?";
    protected static final String DELETE_STATEMENT_PL = "DELETE FROM productLabel WHERE uniqueID = ?";

    protected StatementsJDBC() {
    }
}
