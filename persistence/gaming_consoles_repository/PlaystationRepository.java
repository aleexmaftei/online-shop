package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Playstation;
import exceptions.InvalidDataException;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.Set;

public final class PlaystationRepository implements GenericRepository<Playstation> {

    private Set<Playstation> playstations = new HashSet<>();

    @Override
    public void add(Playstation entity) {
        Playstation onePlaystation = new Playstation(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getProductionYear());
        this.playstations.add(onePlaystation);
    }

    @Override
    public void printAllRepository() {
        for (Playstation playstation : this.playstations)
            playstation.printProduct();
    }

    @Override
    public void delete() {
        playstations.clear();
    }

    @Override
    public void delete(int index) throws InvalidDataException {
        if (index < 0 || index > playstations.size())
            throw new InvalidDataException("Indexul este invalid!");
        // to do...
    }
}
