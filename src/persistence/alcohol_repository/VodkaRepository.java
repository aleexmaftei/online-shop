package persistence.alcohol_repository;

import domain.products.alcohol.Vodka;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.LinkedList;
import java.util.List;

public final class VodkaRepository implements GenericRepository<Vodka> {

    private List<Vodka> vodkas = new LinkedList<>();

    @Override
    public void add(Vodka entity) {
        Vodka oneVodka = new Vodka(entity.getAlcoholPercentage(), entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getIngredients());
        this.vodkas.add(oneVodka);
    }

    @Override
    public void printAllRepository() {
        for (Vodka vodka : this.vodkas)
            vodka.printProduct();
    }

    @Override
    public void delete() {
        vodkas.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > vodkas.size())
            throw new InvalidDataException("Indexul este invalid!");
        vodkas.remove(index);
    }
}
