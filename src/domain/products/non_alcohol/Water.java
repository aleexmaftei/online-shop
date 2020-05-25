package domain.products.non_alcohol;

public final class Water extends NonAlcoholType {
    public Water(Double price, String name, String originCountry) {
        super(price, name, originCountry, null, "Non-alcohol");
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

    @Override
    public String toString() {
        return "Water{" +
                "price='" + getPrice() + '\'' +
                ", name='" + getName() + '\'' +
                ", origin country=" + getOriginCountry() +
                ", product type=" + getProductType() +
                ", id=" + getId() +
                '}';
    }
}
