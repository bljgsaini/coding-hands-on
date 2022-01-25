package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        int []nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        int[] ans = intersect(nums1, nums2);
        //print ans
    }

    /* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/

    public static int[] intersect(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j= 0;
        List<Integer> list = new ArrayList<>();
        while(i < nums1Length && j < nums2Length){
            if(nums1[i] == nums2[j] ){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int n = list.size();
        int ans[] = new int[n];
        int k = 0;
        for(Integer item : list){
            ans[k++] = item;
        }

        return ans;

        /*
        Map<Integer, Integer> map = new HashMap<>();

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        for(int i=0; i<nums1Length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        List<Integer>ans = new ArrayList<>();
        for(int i=0; i<nums2Length; i++){
            if(map.containsKey(nums2[i])){
                ans.add(nums2[i]);
                int freq = map.get(nums2[i]);
                if(freq == 1){
                    map.remove(nums2[i]);
                }else{
                    map.put(nums2[i], freq-1);
                }
            }
        }

        int n = ans.size();

        int intersectionArray[] = new int[n];

        int k = 0;
        for(Integer item : ans){
            intersectionArray[k] = item;
            k++;
        }


        return intersectionArray;
        */

    }

}
