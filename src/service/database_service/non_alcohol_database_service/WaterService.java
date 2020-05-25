package service.database_service.non_alcohol_database_service;

import domain.products.non_alcohol.Water;
import persistence.jdbc_repository.non_alcohol_jdbc_repository.WaterRepositoryJDBC;

public final class WaterService {
    private static WaterService instance;

    private final WaterRepositoryJDBC waterRepository = WaterRepositoryJDBC.getInstance();

    private WaterService() {
    }

    public static WaterService getInstance() {
        if (instance == null) {
            instance = new WaterService();
        }

        return instance;
    }

    public Water save(Double price, String name, String originCountry) {
        Water water = new Water(price, name, originCountry);
        return waterRepository.save(water);
    }

    public Water find(Double price, String name, String originCountry) {
        Water water = new Water(price, name, originCountry);
        return waterRepository.find(water);
    }

    public Water findName(String name) {
        return waterRepository.findName(name);
    }

    public Water update(Water oldWater, Water newWater) {
        return waterRepository.update(oldWater, newWater);
    }

    public boolean delete(Water water) {
        return waterRepository.delete(water);
    }

}
