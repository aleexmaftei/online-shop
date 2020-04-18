package domain.products.non_alcohol;

import domain.products.ProductLabel;

public abstract class NonAlcoholType extends ProductLabel implements Comparable<NonAlcoholType> {
    protected String type;

    /*
     *  @param price - price of the object
     *  @param producer - producer of the object
     *  @param originCountry - the country in which this object was produced
     *  @param ingredients - ingredients of the object
     *  @param productType - what kind of object it is (alcohol, non-alcohol etc)
     */
    public NonAlcoholType(Double price, String producer, String originCountry, String ingredients, String productType) {
        super(price, producer, originCountry, ingredients, productType);
    }

    public NonAlcoholType() {
        super();
    }

    // set, get for type
    public abstract void setType();

    public String getType() {
        return this.type;
    }

    public void printProduct() {
        System.out.println("Product type: " + this.getProductType());
        System.out.println("Price: " + this.getPrice());
        System.out.println("Producer: " + this.getProducer());
        System.out.println("Origin country: " + this.getOriginCountry());
        System.out.println("Drink type: " + this.getType());
        if (this.getIngredients() != null)
            System.out.println("Ingredients: " + this.getIngredients());
        System.out.println();
    }

    @Override
    public int compareTo(NonAlcoholType nonAlcohol) {
        return this.getPrice().compareTo(nonAlcohol.getPrice());
    }

}
