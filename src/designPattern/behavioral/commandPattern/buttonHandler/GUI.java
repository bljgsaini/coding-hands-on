package designPattern.behavioral.commandPattern.buttonHandler;

public class GUI {

    private static Document document = new Document();

    public static void main(String[] args) {
        Button saveButton = new Button("save");
        Button printButton = new Button("print");
        Button viewButton = new Button("view");

        saveButton.click(new SaveCommand(document));
        printButton.click(new PrintCommand(document));
        viewButton.click(new ViewDocument(document));

    }

}
