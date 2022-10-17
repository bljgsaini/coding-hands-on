package designPattern.behavioral.commandPattern.orderHandler;

public class OrderHandler {

  public void invoke(Command command) {
    command.execute();
  }

}
