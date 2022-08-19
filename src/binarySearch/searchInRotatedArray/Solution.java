package binarySearch.searchInRotatedArray;


//33. Search in Rotated Sorted Array
//https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1

/* There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104 */

class Solution{

    public static void main(String[] args) {
        
    }

    public int binarySearchLeetcodeSolution(int[] nums, int low, int high, int k){
        if(low > high ) return -1;
        int mid = low + (high - low)/2;
        if(nums[mid] == k ) return mid;
        // if  below if is true then first half array is sorted else other half
        if(nums[low] <= nums[mid]){
            if(k > nums[mid] || k < nums[low]){
                return binarySearchLeetcodeSolution(nums, mid+1, high, k);
            }else {
                return binarySearchLeetcodeSolution(nums, low, mid-1, k);
            }
        }else{
            if(k < nums[mid] || k > nums[high]){
                return binarySearchLeetcodeSolution(nums, low, mid-1, k);
            }else {
                return binarySearchLeetcodeSolution(nums, mid+1, high, k);
            }
        }

    }

    int searchApproach1(int A[], int l, int h, int key){
        int pivotIndex = findPivot(A, l, h);
        int index = binarySearch(A, l, pivotIndex-1, key);
        if( index == -1 ){
            index = binarySearch(A, pivotIndex, h, key);
        }
        return index;
    }


    int binarySearch(int arr[], int low, int high, int key){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == key ) return mid;
            if(arr[mid] < key ) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    int findPivot(int arr[], int l, int h){
        while(l <= h){
            int mid = l + (h - l)/2;
            if(mid-1 >= l && arr[mid] < arr[mid-1] ) return mid;
            if(mid+1 <= h && arr[mid] > arr[mid+1] ) return mid+1;
            if(arr[mid] > arr[l] ) l = mid+1;
            else h = mid-1;
        }
        return -1;
    }

}
