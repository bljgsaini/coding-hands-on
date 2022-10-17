package designPattern.behavioral.commandPattern.orderHandler;

public class ReturnOrderHandler implements Command {

    private Jacket jacket;

    public ReturnOrderHandler(Jacket jacket){
        this.jacket = jacket;
    }

    @Override
    public void execute() {
        jacket.returnOrder();
    }
}
