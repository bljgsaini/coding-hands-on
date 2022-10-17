package designPattern.behavioral.chainOfResponsibility.example1;

public class SliderDocumentHandler extends DocumentHandler{

    public SliderDocumentHandler(DocumentHandler next) {
        super(next);
    }

    @Override
    public void openDocument(String ext) {
        if(ext.equalsIgnoreCase("ppt")){
            System.out.println("ppt document is opening");
        }else{
            super.openDocument(ext);
        }
    }

}
