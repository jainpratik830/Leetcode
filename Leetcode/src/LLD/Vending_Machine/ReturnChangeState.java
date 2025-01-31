package LLD.Vending_Machine;

public class ReturnChangeState  implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product p) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertCoin(Coin c) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertNote(Note n) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void returnChange() {
        if (vendingMachine.totalPayment> vendingMachine.getSelectedProduct().getPrice()){
            System.out.println("Returned change: "+(vendingMachine.totalPayment- vendingMachine.getSelectedProduct().getPrice()));
            vendingMachine.resetPayment();
        }else {
            System.out.println("No change to return.");
        }
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());

    }
}
