package persistence.non_alcohol_repository;

import domain.products.non_alcohol.Water;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.LinkedList;
import java.util.List;

public final class WaterRepository implements GenericRepository<Water> {

    private List<Water> waters = new LinkedList<>();

    @Override
    public void add(Water entity) {
        Water oneWater = new Water(entity.getPrice(), entity.getProducer(), entity.getOriginCountry());
        this.waters.add(oneWater);
    }

    @Override
    public void printAllRepository() {
        for (Water water : this.waters)
            water.printProduct();
    }

    @Override
    public void delete() {
        waters.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > waters.size())
            throw new InvalidDataException("Indexul este invalid!");
        waters.remove(index);
    }


}
