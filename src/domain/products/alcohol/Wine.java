package domain.products.alcohol;

public final class Wine extends AlcoholType {

    public Wine(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        super(alcoholPercentage, price, name, originCountry, ingredients, "alcohol");
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

    public static String getWritePath() {
        return "src/files/write_database/alcohol/wineCSV";
    }

    @Override
    public String toString() {
        return "Wine{" +
                "price='" + getPrice() + '\'' +
                ", name='" + getName() + '\'' +
                ", origin country=" + getOriginCountry() +
                ", ingredients=" + getIngredients() +
                ", product type=" + getProductType() +
                ", id=" + getId() +
                '}';
    }
}
