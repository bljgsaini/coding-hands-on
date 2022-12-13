package designPattern.behavioral.mementoPattern.example1;

import javax.xml.soap.Text;

public class TextDocument {

    private String text;
    private Memento memento;

    public TextDocument() {
        this.text = "";
        memento = new Memento("");
    }

    public void write(String text){
        this.text += text;
    }

    public void print(){
        System.out.println("Written text: " + text);
    }

    public void save(){
        memento.setState(text);
    }

    public void undo(){
        text = memento.getState();
    }




}
