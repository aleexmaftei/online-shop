package domain.products.alcohol;

public final class Beer extends AlcoholType {

    public Beer(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients) {
        super(alcoholPercentage, price, producer, originCountry, ingredients, "alcohol");
        this.setAlcoholType();
    }

    public Beer() {
        super();
    }

    /* abstract function implementation from AlcoholType class */
    @Override
    public void setAlcoholType() {
        alcoholType = "Beer";
    }

    public String getPath() {
        return "src/files/database/alcohol/beerCSV";
    }

    public static String getWritePath(){
        return "src/files/write_database/alcohol/beerCSV";
    }
}
