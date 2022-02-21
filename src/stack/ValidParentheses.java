package stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//20. Valid Parentheses
public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']','[');

        Stack<Character> stack = new Stack();

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.empty() || stack.peek() != map.get(ch)){
                    return false;
                }else{
                    stack.pop();
                }
            }

        }
        if(stack.empty() == true) return true;
        return false;

    }

}

