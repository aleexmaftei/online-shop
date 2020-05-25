package domain.products.gaming_consoles;

public final class Playstation extends ConsoleType {
    public Playstation(Double price, String name, String originCountry, String productionYear) {
        super(price, name, originCountry, "Gaming console", "Playstation", productionYear);
    }

    public Playstation() {
        super();
    }

    public String getPath() {
        return "src/files/database/gaming_consoles/playstationCSV";
    }

    public static String getWritePath() {
        return "src/files/write_database/gaming_consoles/playstationCSV";
    }
}
