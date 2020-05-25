package domain.products.gaming_consoles;

public final class Xbox extends ConsoleType {
    public Xbox(Double price, String name, String originCountry, String productionYear) {
        super(price, name, originCountry, "Gaming console", "Xbox", productionYear);
    }

    public Xbox() {
        super();
    }

    public String getPath() {
        return "src/files/database/gaming_consoles/xboxCSV";
    }

    public static String getWritePath() {
        return "src/files/write_database/gaming_consoles/xboxCSV";
    }
}
