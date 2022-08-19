package binarySearch.medianOfTwoSortedArraysLeetcode4;


//4. Median of Two Sorted Arrays
/* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 */
public class Solution {
    public static void main(String[] args) {

    }

    public double findMedianSortedArraysUsingBinarySearch(int[] nums1, int[] nums2) {
        if(nums1 == null  && nums2 == null ) return 0;
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int half = (m+n)/2;
        int low = 0, high = m-1;
        //System.out.println("m+n=>" + (m + n));
        while(true){
            int i = Math.floorDiv(high+low, 2);
            int j = half-i-2;
            double firstLeft = i<0 ? Integer.MIN_VALUE : nums1[i];
            double firstRight = i+1 >= m ? Integer.MAX_VALUE : nums1[i+1];
            double secondLeft = j<0 ? Integer.MIN_VALUE : nums2[j];
            double secondRight = j+1>=n ? Integer.MAX_VALUE : nums2[j+1];
            if(firstLeft <= secondRight && secondLeft <= firstRight){
                if( (m+n)%2 == 1 ) return Math.min(firstRight, secondRight);
                return (Math.max(firstLeft, secondLeft) + Math.min(firstRight, secondRight))/2;
            }
            else if(firstLeft > secondRight ) high = i-1;
            else low = i+1;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        int totalSize = nums1Size + nums2Size;
        int medianUpperLimit = totalSize/2;
        int currentValueInMerge = Integer.MIN_VALUE;
        int previousValueInMerge = Integer.MIN_VALUE;
        int currentIndexInMerge = 0;
        int nums1Pointer = 0;
        int nums2Pointer = 0;
        while(nums1Pointer < nums1Size || nums2Pointer < nums2Size){
            previousValueInMerge = currentValueInMerge;
            if( nums1Pointer < nums1Size && nums2Pointer < nums2Size){
                if(nums1[nums1Pointer] <= nums2[nums2Pointer]){
                    currentValueInMerge = nums1[nums1Pointer];
                    nums1Pointer++;
                }else{
                    currentValueInMerge = nums2[nums2Pointer];
                    nums2Pointer++;
                }
            }else if(nums1Pointer < nums1Size){
                currentValueInMerge = nums1[nums1Pointer];
                nums1Pointer++;

            }else if(nums2Pointer < nums2Size){
                currentValueInMerge = nums2[nums2Pointer];
                nums2Pointer++;
            }

            if(currentIndexInMerge == medianUpperLimit){
                if(totalSize%2 == 0){
                    return ((double)previousValueInMerge + currentValueInMerge)/2;
                }else{
                    return currentValueInMerge;
                }
            }
            currentIndexInMerge +=1;
        }

        return 0;
    }
}
