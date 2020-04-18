package domain.products.alcohol;

import domain.products.ProductLabel;

public abstract class AlcoholType extends ProductLabel {
    private Integer alcoholPercentage;
    protected String alcoholType;

    /*  @param price - price of the object
        @param producer - producer of the object
        @param originCountry - the country in which this object was produced
        @param ingredients - ingredients of the object
        @param productType - what kind of object it is (alcohol, non-alcohol etc)
    */
    public AlcoholType(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients, String productType) {
        super(price, producer, originCountry, ingredients, productType);
        this.alcoholPercentage = alcoholPercentage;
    }

    public AlcoholType() {
        super();
    }

    // set, get for alcoholPercentage
    public Integer getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(Integer alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    // abstract set, get for types of alcohol
    public abstract void setAlcoholType();

    public String getAlcoholType() {
        return alcoholType;
    }

    /* for printing  domain.products in console */
    public void printProduct() {
        System.out.println("Product type: " + this.getProductType());
        System.out.println("Price: " + this.getPrice());
        System.out.println("Producer: " + this.getProducer());
        System.out.println("Origin country: " + this.getOriginCountry());
        System.out.println("Alcohol type: " + this.getAlcoholType());
        System.out.println("Alcohol Percentage: " + this.getAlcoholPercentage());
        System.out.println("Ingredients: " + this.getIngredients());
        System.out.println();
    }
}
