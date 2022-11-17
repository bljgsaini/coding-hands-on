package designPattern.behavioral.interpreterPattern.interpretVariables;

public class VariableFirstCharNotUnderscore implements Expression {
    VariableFirstCharNotCapital variableFirstCharNotCapital = new VariableFirstCharNotCapital();
    @Override
    public String interpret(String context) {
        if(context.startsWith("_")){
            context = context.substring(1);
        }
        return variableFirstCharNotCapital.interpret(context);
    }
}
