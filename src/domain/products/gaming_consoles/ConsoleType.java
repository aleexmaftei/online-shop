package domain.products.gaming_consoles;

import domain.products.ProductLabel;

public abstract class ConsoleType extends ProductLabel {

    private String productionYear;
    private String consoleName;
    /*
     *   @param price - price of the object
     *   @param producer - producer of the object
     *   @param originCountry - the country in which this object was produced
     *   @param ingredients - ingredients of the object
     *   @param productType - what kind of object it is (alcohol, non-alcohol etc)
     */

    public ConsoleType(Double price, String producer, String originCountry, String productType, String consoleName, String productionYear) {
        super(price, producer, originCountry, null, productType);
        this.setProductionYear(productionYear);
        this.setConsoleName(consoleName);
    }

    private void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    private void setConsoleName(String consoleName) {
        this.consoleName = consoleName;
    }

    public String getProductionYear() {
        return this.productionYear;
    }

    public void printProduct() {
        System.out.println("Product type: " + this.getProductType());
        System.out.println("Console name: " + this.consoleName);
        System.out.println("Price: " + this.getPrice());
        System.out.println("Producer: " + this.getProducer());
        System.out.println("Origin country: " + this.getOriginCountry());
        if (this.productionYear != null)
            System.out.println("Production Year: " + this.productionYear);
        System.out.println();
    }


}
