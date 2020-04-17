package domain.products.gaming_consoles;

public final class Xbox extends ConsoleType {
    public Xbox(Double price, String producer, String originCountry, String productionYear) {
        super(price, producer, originCountry, "Gaming console", "Xbox", productionYear);
    }
}
