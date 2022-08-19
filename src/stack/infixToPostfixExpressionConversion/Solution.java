package stack.infixToPostfixExpressionConversion;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1/
public class Solution {
    public static void main(String[] args) {

    }

    public static String infixToPostfix(String exp) {
        Character[] operator = new Character[]{'+', '-', '*', '/', '^', '(', ')'};
        Set<Character> operatorSet = new HashSet<Character>(Arrays.asList(operator));
        Map<Character, Integer> precedMap = new HashMap<Character, Integer>() {{
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
            put('^', 3);
        }};

        Stack<Character> stack = new Stack<Character>();
        char[] expArray = exp.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<expArray.length; i++){
            if(!operatorSet.contains(expArray[i])){
                sb.append(expArray[i]);
            }else{
                if(stack.size() == 0 || expArray[i] == '(' ){
                    stack.push(expArray[i]);
                }else if(expArray[i] == ')'){
                    while(stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }else{
                    while( stack.size()>0 && stack.peek() != '('
                            && precedMap.get(stack.peek()) >= precedMap.get(expArray[i])) {
                        sb.append(stack.pop());
                    }
                    stack.push(expArray[i]);
                }
            }
        }
        while(stack.size()>0){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
