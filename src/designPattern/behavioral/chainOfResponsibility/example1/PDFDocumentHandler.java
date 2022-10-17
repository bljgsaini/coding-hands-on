package designPattern.behavioral.chainOfResponsibility.example1;

public class PDFDocumentHandler extends DocumentHandler{

    public PDFDocumentHandler(DocumentHandler next) {
        super(next);
    }

    @Override
    public void openDocument(String ext) {
        if(ext.equalsIgnoreCase("pdf")){
            System.out.println("pdf document is opening");
        }else{
            super.openDocument(ext);
        }
    }
}
