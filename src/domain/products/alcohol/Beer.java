package domain.products.alcohol;

public final class Beer extends AlcoholType {

    public Beer(Integer alcoholPercentage, Double price, String name, String originCountry, String ingredients) {
        super(alcoholPercentage, price, name, originCountry, ingredients, "alcohol");
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

    @Override
    public String toString() {
        return "Beer{" +
                "price='" + getPrice() + '\'' +
                ", name='" + getName() + '\'' +
                ", origin country=" + getOriginCountry() +
                ", ingredients=" + getIngredients() +
                ", product type=" + getProductType() +
                ", id=" + getId() +
                '}';
    }
}
