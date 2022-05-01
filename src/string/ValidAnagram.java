package string;

//242. Valid Anagram
public class ValidAnagram {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m != n ) return false;

        int arr[] = new int[26];

        for(int i=0; i< m || i< n ; i++){
            if(i< m ) arr[ s.charAt(i) - 'a']++;
            if( i < n ) arr[ t.charAt(i) - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(arr[i] != 0)return false;
        }

        return true;
    }

}
