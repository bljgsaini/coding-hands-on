package designPattern.behavioral.commandPattern.buttonHandler;

public class ViewDocument implements Command {

    private Document document;

    public ViewDocument(Document document){
        this.document = document;
    }

    @Override
    public void execute() {
        document.view();
    }
}
