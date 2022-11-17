package designPattern.behavioral.interpreterPattern.checkGrammer;

import java.util.Arrays;
import java.util.List;

public class ContainsNoDuplicate implements Expression {

    EndsWithPeriod endsWithPeriod = new EndsWithPeriod();

    @Override
    public String interpret(String context) {
        context = noRepeatedWords(context);
        return endsWithPeriod.interpret(context);
    }

    public static String noRepeatedWords(String context) {
        List<String> list = Arrays.asList(context.split(" "));
        int size = list.size() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String word = list.get(i);
            if(!word.equals(list.get(i + 1))) {
                sb.append(word).append(" ");
            }
        }
        sb.append(list.get(size));
        context = sb.toString();

        return context;
    }

}
