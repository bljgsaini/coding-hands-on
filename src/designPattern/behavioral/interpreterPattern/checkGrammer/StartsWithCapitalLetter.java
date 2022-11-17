package designPattern.behavioral.interpreterPattern.checkGrammer;

public class StartsWithCapitalLetter implements Expression{

    ContainsNoDuplicate containsNoDuplicate = new ContainsNoDuplicate();

    @Override
    public String interpret(String context) {
        context = context.substring(0,1).toUpperCase() + context.substring(1);
        return containsNoDuplicate.interpret(context);
    }
}
