package domain.products.non_alcohol;

public final class Soda extends NonAlcoholType {
    public Soda(Double price, String producer, String originCountry, String ingredients) {
        super(price, producer, originCountry, ingredients, "Non-alcohol");
        this.setType();
    }

    public Soda() {
        super();
    }

    /* abstract function implementation from NonAlcoholType class */
    @Override
    public void setType() {
        type = "Soda";
    }

    public String getPath() {
        return "src/files/database/non_alcohol/sodaCSV";
    }

    public static String getWritePath() {
        return "src/files/write_database/non_alcohol/sodaCSV";
    }
}
