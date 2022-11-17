package designPattern.behavioral.interpreterPattern.checkGrammer;

public class Main {

  public static void main(String[] args) {

    String context = "this is a a sentence";

    StartsWithCapitalLetter startsWithCapitalLetter = new StartsWithCapitalLetter();
    context = startsWithCapitalLetter.interpret(context);

    System.out.println(context);

  }

}
