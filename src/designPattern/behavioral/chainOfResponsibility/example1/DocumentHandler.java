package designPattern.behavioral.chainOfResponsibility.example1;

public abstract class DocumentHandler {

    private DocumentHandler next;

    public DocumentHandler(DocumentHandler next){
        this.next = next;
    }

    public void openDocument(String ext){
        if(next!= null){
            next.openDocument(ext);
        }
    }

}
