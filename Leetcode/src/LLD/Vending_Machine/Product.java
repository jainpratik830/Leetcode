package LLD.Vending_Machine;

public class Product {

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    private final String productName;
    private final int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }


}
