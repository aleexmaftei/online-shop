package domain.products.alcohol;

public final class Wine extends AlcoholType {

    public Wine(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients) {
        super(alcoholPercentage, price, producer, originCountry, ingredients, "alcohol");
        this.setAlcoholType();
    }

    public Wine() {
        super();
    }

    /* abstract function implementation from AlcoholType class */
    @Override
    public void setAlcoholType() {
        alcoholType = "Wine";
    }

    public String getPath() {
        return "src/files/database/alcohol/wineCSV";
    }
}
