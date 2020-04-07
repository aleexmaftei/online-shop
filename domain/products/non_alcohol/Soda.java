package domain.products.non_alcohol;

public final class Soda extends NonAlcoholType {
    public Soda(Double price, String producer, String originCountry, String ingredients) {
        super(price, producer, originCountry, ingredients, "Non-alcohol");
        this.setType();
    }

    /* abstract function implementation from NonAlcoholType class */
    @Override
    public void setType() {
        type = "Soda";
    }


}
