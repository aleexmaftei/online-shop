package domain.products.gaming_consoles;

public final class Playstation extends ConsoleType {
    public Playstation(Double price, String producer, String originCountry, String productionYear) {
        super(price, producer, originCountry, "Gaming console", "Playstation", productionYear);
    }

    public Playstation() {
        super();
    }

    public String getPath() {
        return "src/files/database/gaming_consoles/playstationCSV";
    }
}
