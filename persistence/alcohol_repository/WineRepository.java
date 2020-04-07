package persistence.alcohol_repository;

import domain.products.alcohol.Wine;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.LinkedList;
import java.util.List;

public final class WineRepository implements GenericRepository<Wine> {

    private List<Wine> wines = new LinkedList<>();

    @Override
    public void add(Wine entity) {
        Wine oneWine = new Wine(entity.getAlcoholPercentage(), entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getIngredients());
        this.wines.add(oneWine);
    }

    @Override
    public void printAllRepository() {
        for (Wine wine : this.wines)
            wine.printProduct();
    }

    @Override
    public void delete() {
        wines.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > wines.size())
            throw new InvalidDataException("Indexul este invalid!");
        wines.remove(index);
    }
}
