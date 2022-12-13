package designPattern.structural.proxy.imageGalleryExample.end;

import java.awt.image.BufferedImage;
import java.util.Objects;

public class ProxyImage implements DisplayObject{

    private String fileName;

    private ImageFile imageFile;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(Objects.isNull(imageFile)){
            imageFile = new ImageFile(fileName);
        }
        imageFile.display();
    }
}
