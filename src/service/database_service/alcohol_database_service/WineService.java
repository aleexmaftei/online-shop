package service.database_service.alcohol_database_service;

import domain.products.alcohol.Wine;
import persistence.jdbc_repository.alcohol_jdbc_repository.WineRepositoryJDBC;

public final class WineService {
    private static WineService instance;

    private final WineRepositoryJDBC wineRepository = WineRepositoryJDBC.getInstance();

    private WineService() {
    }

    public static WineService getInstance() {
        if (instance == null) {
            instance = new WineService();
        }

        return instance;
    }

    public Wine save(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        Wine wine = new Wine(alcoholPercentage, price, name, originCountry, ingredients);
        return wineRepository.save(wine);
    }

    public Wine find(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        Wine wine = new Wine(alcoholPercentage, price, name, originCountry, ingredients);
        return wineRepository.find(wine);
    }

    public Wine findName(String name) {
        return wineRepository.findName(name);
    }

    public Wine update(Wine oldWine, Wine newWine) {
        return wineRepository.update(oldWine, newWine);
    }

    public boolean delete(Wine wine) {
        return wineRepository.delete(wine);
    }
}
