package service.database_service.alcohol_database_service;

import domain.products.alcohol.Vodka;
import persistence.jdbc_repository.alcohol_jdbc_repository.VodkaRepositoryJDBC;

public final class VodkaService {
    private static VodkaService instance;

    private final VodkaRepositoryJDBC vodkaRepository = VodkaRepositoryJDBC.getInstance();

    private VodkaService() {
    }

    public static VodkaService getInstance() {
        if (instance == null) {
            instance = new VodkaService();
        }

        return instance;
    }

    public Vodka save(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        Vodka vodka = new Vodka(alcoholPercentage, price, name, originCountry, ingredients);
        return vodkaRepository.save(vodka);
    }

    public Vodka find(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        Vodka vodka = new Vodka(alcoholPercentage, price, name, originCountry, ingredients);
        return vodkaRepository.find(vodka);
    }

    public Vodka findName(String name) {
        return vodkaRepository.findName(name);
    }

    public Vodka update(Vodka oldVodka, Vodka newVodka) {
        return vodkaRepository.update(oldVodka, newVodka);
    }

    public boolean delete(Vodka vodka) {
        return vodkaRepository.delete(vodka);
    }
}
