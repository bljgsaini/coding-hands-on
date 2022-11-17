package designPattern.behavioral.interpreterPattern.interpretVariables;

public class VariableFirstCharNotCapital implements Expression {

    VariableNameNotPrimitive variableNameNotPrimitive = new VariableNameNotPrimitive();

    @Override
    public String interpret(String context) {
        context = context.substring(0,1).toLowerCase() + context.substring(1);
        return variableNameNotPrimitive.interpret(context);
    }
}
