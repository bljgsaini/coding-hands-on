package stack.infixToPrefixExpressionConversion;

import java.util.*;

//https://www.geeksforgeeks.org/convert-infix-prefix-notation/
public class Solution {
    public static void main(String[] args) {

        String expression = "(A-B/C)*(A/K-L)";
        System.out.println("prefix expression=>" + infixToPrefix(expression));
    }

    public static String infixToPrefix(String exp) {
        Character[] operator = new Character[]{'+', '-', '*', '/', '^', '(', ')'};
        Set<Character> operatorSet = new HashSet<>(Arrays.asList(operator));
        Map<Character, Integer> precedMap = new HashMap<Character, Integer>() {{
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
            put('^', 3);
        }};

        Stack<Character> stack = new Stack<>();
        char[] expArray = exp.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=expArray.length-1; i>=0; i--){
            if(!operatorSet.contains(expArray[i])){
                sb.append(expArray[i]);
            }else{
                char ch = expArray[i];
                if(ch == '(') ch = ')';
                else if(ch == ')') ch = '(';

                if(stack.size() == 0 || ch == '(' ){
                    stack.push(ch);
                }else if(ch == ')'){
                    while(stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }else{
                    while( stack.size()>0 && stack.peek() != '('
                            && ( (precedMap.get(stack.peek()) > precedMap.get(ch))
                                || (expArray[i]=='^' && precedMap.get(stack.peek()) >= precedMap.get(ch)))) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        while(stack.size()>0){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

}
