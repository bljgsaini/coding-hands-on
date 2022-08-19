package binarySearch.hIndexIILeetcode275;


//https://leetcode.com/problems/h-index-ii/
public class Solution {
    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        int low = 0;
        int n = citations.length;
        int high = n - 1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(citations[mid] >= (n-mid) ){
                ans = n-mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

}
