package domain.products.alcohol;

public final class Vodka extends AlcoholType {

    public Vodka(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        super(alcoholPercentage, price, name, originCountry, ingredients, "alcohol");
        this.setAlcoholType();
    }

    public Vodka() {
        super();
    }

    /* abstract function implementation from AlcoholType class */
    @Override
    public void setAlcoholType() {
        alcoholType = "Vodka";
    }

    public String getPath() {
        return "src/files/database/alcohol/vodkaCSV";
    }

    public static String getWritePath() {
        return "src/files/write_database/alcohol/vodkaCSV";
    }

    @Override
    public String toString() {
        return "Vodka{" +
                "price='" + getPrice() + '\'' +
                ", name='" + getName() + '\'' +
                ", origin country=" + getOriginCountry() +
                ", ingredients=" + getIngredients() +
                ", product type=" + getProductType() +
                ", id=" + getId() +
                '}';
    }
}
