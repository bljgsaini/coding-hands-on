package recursion.balancedParanthesisiWithoutStack;

//https://www.geeksforgeeks.org/check-for-balanced-parenthesis-without-using-stack/
public class Solution {
    public static void main(String[] args) {
        char expression[] = "[()]{}{[()()]()}{(]}".toCharArray();
        System.out.println(isBalanced(expression, 0, expression.length-1));
    }

    public static boolean isBalanced(char[] expression, int start, int end){
        if(start > end ) return true;
        if( start == end || expression[start] == ')' || expression[start] == '}' || expression[start] == ']' ) return false;

        char closing = findClosing(expression[start]);
        int i = start;
        int count = 0;
        while(i <= end){
            if(expression[i] == expression[start]) count++;
            if(expression[i] == closing ) {
                count--;
                if(count == 0 ) break;
            }
            i++;
        }
        if( i > end) return false;

        return isBalanced(expression, start+1, i-1) && isBalanced(expression, i+1, end);

    }

    private static char findClosing(char c) {
        if(c == '(') return ')';
        if(c == '{') return '}';
        if( c== '[') return ']';
        return 0;
    }

}
