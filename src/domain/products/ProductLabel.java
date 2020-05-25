package domain.products;

import java.util.UUID;

public abstract class ProductLabel {
    private Double price;
    private String name;
    private String originCountry;
    private String ingredients;
    private String productType;
    private String uniqueID = UUID.randomUUID().toString();

    public ProductLabel(Double price, String name, String originCountry, String ingredients, String productType) {
        this.price = price;
        this.name = name;
        this.originCountry = originCountry;
        this.ingredients = ingredients;
        this.productType = productType;
    }

    public ProductLabel() {
    }

    /* set, get for price */
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    /* set, get for producer */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /* set, get for originCountry */
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginCountry() {
        return this.originCountry;
    }

    /* set, get for ingredients */
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    /* set, get for productType */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    /* set, get for id */
    public String getId() {
        return uniqueID;
    }

    public void setId(String id) {
        uniqueID = id;
    }

    /* for printing  domain.products in console */
    public abstract void printProduct();
}
