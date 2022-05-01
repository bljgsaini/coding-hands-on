package array.medianOfTwoSortedArraysLeetcode4;


//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Solution {
    public static void main(String[] args) {

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

        throw new RuntimeException("exception");

    }

}
