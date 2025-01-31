package LLD.Vending_Machine;

public interface VendingMachineState {

    public void selectProduct(Product p);

    public void insertCoin(Coin c);

    public void insertNote(Note n);

    public void dispenseProduct();

    public void returnChange();

}
