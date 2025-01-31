package LLD.Vending_Machine;

public class ReadyState  implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    private void checkPaymentStatus() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
    @Override
    public void selectProduct(Product p) {
        System.out.println("Product already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin c) {
        vendingMachine.addCoin(c);
        System.out.println("Coin inserted: "+c.getValue());
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note n) {
        vendingMachine.addNote(n);
        System.out.println("Note inserted: "+n.getValue());
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first.");
    }
}
