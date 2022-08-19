package stack.evaluateReversePolishNotationLeetcode150;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


//https://leetcode.com/problems/evaluate-reverse-polish-notation/

/* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

*/
public class Solution {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        Set<String> operatorSet = new HashSet();
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("/");
        operatorSet.add("*");
        Stack<String> stack = new Stack();
        for(int i=tokens.length-1; i>=0; i--){
            if(stack.empty() || operatorSet.contains(tokens[i]) || operatorSet.contains(stack.peek())){
                stack.push(tokens[i]);
            }else{
                int result = Integer.parseInt(tokens[i]);
                while(!stack.empty() && !operatorSet.contains(stack.peek())){
                    int value = Integer.parseInt(stack.pop());
                    String operator = stack.pop();
                    result = solveExp(result, value, operator);
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public int solveExp(int value1, int value2, String operator){
        switch(operator) {
            case "+":
                return value1+value2;
            case "-":
                return value1-value2;
            case "*":
                return value1*value2;
            case "/":
                return (int)(value1/value2);
            default:
                return -1;
        }

    }
}
