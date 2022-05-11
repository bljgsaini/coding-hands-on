package array.mathamatics.countSortedVowelStringsLeetcode1641;

//https://leetcode.com/problems/count-sorted-vowel-strings/
public class Solution {
    public static void main(String[] args) {

    }

    public int countVowelStrings(int n) {
        int aCount = 1, eCount=1, iCount=1, oCount = 1, uCount= 1;

        while(n > 0){
            aCount = aCount + eCount + iCount + oCount + uCount;
            eCount = eCount + iCount + oCount + uCount;
            iCount = iCount + oCount + uCount;
            oCount = oCount + uCount;
            uCount = 1;
            n--;
        }

        return aCount;

    }

}
