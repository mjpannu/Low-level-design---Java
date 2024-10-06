public class VendingMachine {

    private final VendingMachineState  idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private double total;
    Inventory inventory;
    private VendingMachineState currentState;
    private Product selectedProduct;


    private VendingMachine(){
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);

        currentState = idleState;
        total = 0.0;
        selectedProduct = null;
        inventory = new Inventory();


    }
}
