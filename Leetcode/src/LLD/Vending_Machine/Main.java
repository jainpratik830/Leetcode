package LLD.Vending_Machine;

public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = new Product("Coke", 150);
        Product pepsi = new Product("Pepsi", 155);
        Product water = new Product("Water", 20);

        vendingMachine.inventory.addProduct(coke, 5);
        vendingMachine.inventory.addProduct(pepsi, 3);
        vendingMachine.inventory.addProduct(water, 2);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.insertCoin(Coin.TEN);

        // Insert a note
        vendingMachine.insertNote(Note.HUNDRED);
        vendingMachine.insertNote(Note.FIFTY);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(water);

        // Insert insufficient payment
        vendingMachine.insertCoin(Coin.TEN);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.insertCoin(Coin.TEN);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();
    }

}
