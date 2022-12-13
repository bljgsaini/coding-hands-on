package designPattern.behavioral.mementoPattern.example1;

import javax.xml.soap.Text;

public class DocumentViewer {

    private static TextDocument textDocument = new TextDocument();

    public static void main(String[] args) {
        textDocument.write("Hello");
        textDocument.save();
        textDocument.print();
        textDocument.write(" World");
        textDocument.print();
        textDocument.undo();
        textDocument.print();
    }

}
