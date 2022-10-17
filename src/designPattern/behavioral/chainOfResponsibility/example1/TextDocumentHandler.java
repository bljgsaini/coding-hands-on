package designPattern.behavioral.chainOfResponsibility.example1;

public class TextDocumentHandler extends DocumentHandler{

    public TextDocumentHandler(DocumentHandler next) {
        super(next);
    }

    @Override
    public void openDocument(String ext) {
        if(ext.equalsIgnoreCase("txt")){
            System.out.println("txt document is opening");
        }else{
            super.openDocument(ext);
        }
    }

}
