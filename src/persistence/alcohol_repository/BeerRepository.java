package persistence.alcohol_repository;

import domain.products.alcohol.Beer;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.LinkedList;
import java.util.List;

public final class BeerRepository implements GenericRepository<Beer> {

    private List<Beer> beers = new LinkedList<>();

    @Override
    public void add(Beer entity) {
        Beer oneBeer = new Beer(entity.getAlcoholPercentage(), entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getIngredients());
        this.beers.add(oneBeer);
    }

    @Override
    public void printAllRepository() {
        for (Beer beer : this.beers)
            beer.printProduct();
    }

    @Override
    public void delete() {
        beers.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > beers.size())
            throw new InvalidDataException("Indexul este invalid!");
        beers.remove(index);
    }


}
