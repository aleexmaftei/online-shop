package domain.products.gaming_consoles;

public final class Nintendo extends ConsoleType {
    public Nintendo(Double price, String name, String originCountry, String productionYear) {
        super(price, name, originCountry, "Gaming console", "Nintendo", productionYear);
    }

    public Nintendo() {
        super();
    }

    public String getPath() {
        return "src/files/database/gaming_consoles/nintendoCSV";
    }

    public static String getWritePath() {
        return "src/files/write_database/gaming_consoles/nintendoCSV";
    }
}
