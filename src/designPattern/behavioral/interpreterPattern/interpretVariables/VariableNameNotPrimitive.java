package designPattern.behavioral.interpreterPattern.interpretVariables;

public class VariableNameNotPrimitive implements Expression {
    @Override
    public String interpret(String context) {
        if(context.equalsIgnoreCase("int") || context.equalsIgnoreCase("double") || context.equalsIgnoreCase("float")){
            context = context+1;
        }
        return context;
    }
}
