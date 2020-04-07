package persistence.non_alcohol_repository;

import domain.products.non_alcohol.Soda;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.LinkedList;
import java.util.List;

public final class SodaRepository implements GenericRepository<Soda> {

    private List<Soda> sodas = new LinkedList<>();

    @Override
    public void add(Soda entity) {
        Soda oneSoda = new Soda(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getIngredients());
        this.sodas.add(oneSoda);
    }

    @Override
    public void printAllRepository() {
        for (Soda soda : this.sodas)
            soda.printProduct();
    }

    @Override
    public void delete() {
        sodas.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > sodas.size())
            throw new InvalidDataException("Indexul este invalid!");
        sodas.remove(index);
    }
}
