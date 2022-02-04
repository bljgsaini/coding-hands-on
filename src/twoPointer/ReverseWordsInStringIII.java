package twoPointer;

//557. Reverse Words in a String III
public class ReverseWordsInStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = reverseWords(s);
        System.out.println("s = " + s);
    }

    public static String reverseWords(String s) {

        char []arr = s.toCharArray();
        int n = arr.length;
        int i= 0, k=0;
        while(i< n){
            if(arr[i] == ' '){
                reverse(arr, k, i-1);
                k = i+1;
            }
            i++;
        }
        reverse(arr, k, i-1);
        return String.valueOf(arr);
    }

    public static void reverse(char[] arr, int i, int j){
        while(i < j){
            char ch = arr[j];
            arr[j] = arr[i];
            arr[i] = ch;
            i++;
            j--;
        }
    }

}
