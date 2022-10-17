package designPattern.behavioral.commandPattern.buttonHandler;

public class Button {

    private String text;

    public Button(String text){
        this.text = text;
    }

    public void click(Command command){
        command.execute();
    }

}
