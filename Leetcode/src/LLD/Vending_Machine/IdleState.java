package LLD.Vending_Machine;

public class IdleState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void selectProduct(Product p) {
        if (vendingMachine.inventory.isAvailable(p)){
            vendingMachine.setSelectedProduct(p);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product selected: "+p.getProductName());
        }else {
            System.out.println("Product not available: " + p.getProductName());
        }
    }

    @Override
    public void insertCoin(Coin c) {
        System.out.println("Please select the product first");
    }

    @Override
    public void insertNote(Note n) {
        System.out.println("Please select the product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select the product and make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return.");
    }
}
