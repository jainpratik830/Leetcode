package LLD.Vending_Machine;

public class DispenseState  implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product p) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertCoin(Coin c) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertNote(Note n) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setState(vendingMachine.getReadyState());
        Product p =vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(p,-1);
        System.out.println("Product Dispensed: "+p.getProductName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }

}
