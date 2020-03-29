package products.alcohol;

public final class Wine extends AlcoholType
{
    public Wine(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients)
    {
        super(alcoholPercentage, price, producer, originCountry, ingredients, "alcohol");
        this.setAlcoholType();
    }

    /* abstract function implementation from AlcoholType class */
    @Override
    public void setAlcoholType()
    {
        alcoholType = "Wine";
    }

}
