package persistence.jdbc_repository.non_alcohol_jdbc_repository;

import persistence.jdbc_repository.StatementsJDBC;

public final class SodaRepositoryJDBC extends StatementsJDBC {
    private static SodaRepositoryJDBC instance;

    private static final String INSERT_STATEMENT = "INSERT INTO nonAlcoholProducts (type,  uniqueID) VALUES (?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM nonAlcoholProducts WHERE uniqueID = ?";
    private static final String UPDATE_STATEMENT = "UPDATE nonAlcoholProducts SET type = ? WHERE uniqueID = ?";

    private SodaRepositoryJDBC() {
    }

    public static SodaRepositoryJDBC getInstance() {
        if (instance == null) {
            instance = new SodaRepositoryJDBC();
        }

        return instance;
    }
}
