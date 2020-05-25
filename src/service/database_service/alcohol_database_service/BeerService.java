package service.database_service.alcohol_database_service;

import domain.products.alcohol.Beer;
import persistence.jdbc_repository.alcohol_jdbc_repository.BeerRepositoryJDBC;

public final class BeerService {

    private static BeerService instance;

    private final BeerRepositoryJDBC beerRepository = BeerRepositoryJDBC.getInstance();

    private BeerService() {
    }

    public static BeerService getInstance() {
        if (instance == null) {
            instance = new BeerService();
        }

        return instance;
    }

    public Beer save(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        Beer beer = new Beer(alcoholPercentage, price, name, originCountry, ingredients);
        return beerRepository.save(beer);
    }

    public Beer find(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        Beer beer = new Beer(alcoholPercentage, price, name, originCountry, ingredients);
        return beerRepository.find(beer);
    }

    public Beer findName(String name) {
        return beerRepository.findName(name);
    }

    public Beer update(Beer oldBeer, Beer newBeer) {
        return beerRepository.update(oldBeer, newBeer);
    }

    public boolean delete(Beer beer) {
        return beerRepository.delete(beer);
    }
}
