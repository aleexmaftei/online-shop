package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Nintendo;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.Set;

public final class NintendoRepository implements GenericRepository<Nintendo> {

    private Set<Nintendo> nintendos = new HashSet<>();

    @Override
    public void add(Nintendo entity) {
        Nintendo oneNintendo = new Nintendo(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getProductionYear());
        this.nintendos.add(oneNintendo);
    }

    @Override
    public void printAllRepository() {
        for (Nintendo nintendo : this.nintendos)
            nintendo.printProduct();
    }

    @Override
    public void delete() {
        nintendos.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > nintendos.size())
            throw new InvalidDataException("Indexul este invalid!");
        // to do...
    }
}
