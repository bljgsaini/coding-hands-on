package designPattern.behavioral.mementoPattern.example2.end;


public class Adder {

  private int result;
  private Memento memento;

  public Adder(){
    result = 0;
    memento = new Memento(0);
  }

  public void add(int newNumber) {
    result += newNumber;
  }

  public int getResult() {
    return result;
  }

  public void save(){
    memento.setState(result);
  }

  public void undo(){
    result = memento.getState();
  }

}
