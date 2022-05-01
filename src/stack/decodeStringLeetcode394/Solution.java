package stack.decodeStringLeetcode394;

import java.util.ArrayDeque;
import java.util.Deque;

//394. Decode String
public class Solution {

    public static void main(String[] args) {

    }

    int i = 0;
    public String decodeStringRecursion(String s){ // a3[b2[cd]]
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            i++;

            if(ch == '['){
                String tempStr = decodeStringRecursion(s);
                while(num > 0){
                    sb.append(tempStr);
                    num--;
                }
            } else if(Character.isDigit(ch)){
                num = num*10 + ch - '0';
            }else if(ch == ']'){
                return sb.toString();
            }else{
                sb.append(ch);
            }

        }
        return sb.toString();
    }

    public String decodeString(String s) {

        Deque<Character> stack = new ArrayDeque();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ']'){
                stack.addLast(ch);
            }else{
                String str = "";
                while(stack.getLast() != '['){
                    str = String.valueOf(stack.removeLast()) + str;;
                }
                stack.removeLast();
                int num = 0;
                int count = 0;
                while(!stack.isEmpty() && stack.getLast() - '0' >= 0 && stack.getLast() - '0' <= 9  ){
                    int tempNum = stack.removeLast() - '0';
                    num += Math.pow(10, count)*tempNum;
                    count++;
                }
                while(num > 0){
                    for(int k = 0; k<str.length(); k++){
                        stack.addLast(str.charAt(k));
                    }
                    num--;
                }
            }
        }

        String ans = "";
        while( !stack.isEmpty()){
            ans += String.valueOf(stack.removeFirst());
        }
        return ans;

    }

}
