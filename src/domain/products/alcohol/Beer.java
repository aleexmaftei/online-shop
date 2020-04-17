package domain.products.alcohol;

public final class Beer extends AlcoholType {
    private String path = "src/files/database/alcohol/beerCSV";

    public Beer(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients) {
        super(alcoholPercentage, price, producer, originCountry, ingredients, "alcohol");
        this.setAlcoholType();
    }

    /* abstract function implementation from AlcoholType class */
    @Override
    public void setAlcoholType() {
        alcoholType = "Beer";
    }

    public String getPath() {
        return path;
    }

}
