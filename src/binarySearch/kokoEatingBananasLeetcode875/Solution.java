package binarySearch.kokoEatingBananasLeetcode875;


//https://leetcode.com/problems/koko-eating-bananas/
/* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109 */
public class Solution {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println("result =>"+ minEatingSpeed(piles, h));
    }

    static int result;
    public static int minEatingSpeed(int[] piles, int h) {
        result = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        binarySearch(piles, 1, max, h);
        return result;
    }

    public static void binarySearch(int[] piles, int low, int high, int h){
        if(low > high) return;
        int mid = low + (high - low )/2;
        boolean flag = isValidK(piles, mid, h);
        if(flag){
            result = mid;
            binarySearch(piles, low, mid-1, h);
        }else{
            binarySearch(piles, mid+1, high, h);
        }
    }

    public static boolean isValidK(int[] piles, int k, int h){
        int count = 0;
        for(int i=0; i<piles.length; i++){
            count += piles[i]/k;
            if(piles[i]%k != 0){
                count+=1;
            }
        }
        // count will be nagative when integer overflows.
        return count > 0 && count <= h ? true : false;
    }

}
