package LLD.Vending_Machine;

public class VendingMachine {

    Inventory inventory;
    Product selectedProduct;
    int totalPayment;
    private final VendingMachineState idleState,readyState,dispenseState,returnChangeState;
    private VendingMachineState currState;
    private static VendingMachine instance;


    public VendingMachine() {
        inventory = new Inventory();
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        this.currState = idleState;
        selectedProduct = null;
        totalPayment = 0;
    }

    public static synchronized VendingMachine getInstance(){
        if (instance==null){
            instance = new VendingMachine();
        }

        return instance;
    }

    public void selectProduct(Product product){
        currState.selectProduct(product);
    }

    public  void insertCoin(Coin coin){

        currState.insertCoin(coin);
    }
    public void insertNote(Note n){
        currState.insertNote(n);
    }

    public void dispenseProduct(){
        currState.dispenseProduct();
    }

    public void returnChange(){
        currState.returnChange();
    }

    public void setState(VendingMachineState state){
        currState=state;
    }

    VendingMachineState getIdleState() {
        return idleState;
    }

    VendingMachineState getReadyState() {
        return readyState;
    }

    VendingMachineState getDispenseState() {
        return dispenseState;
    }

    VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    Product getSelectedProduct() {
        return selectedProduct;
    }

    void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    void resetSelectedProduct() {
        selectedProduct = null;
    }

    double getTotalPayment() {
        return totalPayment;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    void addNote(Note note) {
        totalPayment += note.getValue();
    }

    void resetPayment() {
        totalPayment = 0;
    }
}
