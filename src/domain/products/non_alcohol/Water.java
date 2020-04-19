package domain.products.non_alcohol;

public final class Water extends NonAlcoholType {
    public Water(Double price, String producer, String originCountry) {
        super(price, producer, originCountry, null, "Non-alcohol");
        this.setType();
    }

    public Water() {
        super();
    }

    /* abstract function implementation from NonAlcoholType class */
    @Override
    public void setType() {
        type = "Water";
    }

    public String getPath() {
        return "src/files/database/non_alcohol/waterCSV";
    }

    public static String getWritePath() {
        return "src/files/write_database/non_alcohol/waterCSV";
    }
}
