package products.non_alcohol;

public final class Water extends NonAlcoholType
{
    public Water(Double price, String producer, String originCountry)
    {
        super(price, producer, originCountry, null, "Non-alcohol");
        this.setType();
    }

    /* abstract function implementation from NonAlcoholType class */
    @Override
    public void setType() { type = "Water"; }

}
