package LLD.Vending_Machine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    private final Map<Product,Integer> products;

    public Inventory() {
        products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product,int quantity){
        products.put(product,quantity);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void updateQuantity(Product product,int quantity){
        products.put(product,products.getOrDefault(product,0)+ quantity);
    }

    public int getQuantity(Product product){
        return products.getOrDefault(product,0);
    }

    public boolean isAvailable(Product product){
        return products.containsKey(product) && this.getQuantity(product)>0;
    }

}
