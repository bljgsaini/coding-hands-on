package string;

import java.util.*;

public class RemoveDuplicateLetters316 {


    public String removeDuplicateLetters(String s) {
        Set<Character> visited = new HashSet();
        Map<Character, Integer> map = new HashMap();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        Stack<Character> stack = new Stack();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!visited.contains(ch)){
                while(!stack.isEmpty() && stack.peek() > ch ){
                    if(map.get(stack.peek()) == 0 ) break;
                    visited.remove(stack.peek());
                    stack.pop();
                }
                stack.push(ch);
                visited.add(ch);
            }
            map.put(ch, map.get(ch)-1);
        }

        StringBuilder sb = new StringBuilder();
        for( char ch: stack ){
            sb.append(ch);
        }

        return sb.toString();

    }

}
