package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Xbox;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.Set;

public final class XboxRepository implements GenericRepository<Xbox> {

    private Set<Xbox> xboxes = new HashSet<>();

    @Override
    public void add(Xbox entity) {
        Xbox oneXbox = new Xbox(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getProductionYear());
        this.xboxes.add(oneXbox);
    }

    @Override
    public void printAllRepository() {
        for (Xbox xbox : this.xboxes)
            xbox.printProduct();
    }

    @Override
    public void delete() {
        xboxes.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > xboxes.size())
            throw new InvalidDataException("Indexul este invalid!");
        // to do...
    }
}
