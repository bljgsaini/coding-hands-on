package string;

//344. Reverse String
public class ReverseString {
    public static void main(String[] args) {

    }

    public static void reverseString(char[] s) {
        int n = s.length;

        int left = 0, right = n-1;

        while(left < right){
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }

    }

}
