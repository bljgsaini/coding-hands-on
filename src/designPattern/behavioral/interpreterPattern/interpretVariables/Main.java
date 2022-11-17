package designPattern.behavioral.interpreterPattern.interpretVariables;

public class Main {
    public static void main(String[] args) {
        String context = "_Int";
        VariableFirstCharNotUnderscore variableFirstCharNotUnderscore = new VariableFirstCharNotUnderscore();
        context = variableFirstCharNotUnderscore.interpret(context);
        System.out.println("new context=> " + context);
    }
}
