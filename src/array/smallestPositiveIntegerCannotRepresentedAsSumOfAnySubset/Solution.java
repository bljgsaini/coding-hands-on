package array.smallestPositiveIntegerCannotRepresentedAsSumOfAnySubset;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
public class Solution {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5};
        int arr2[] = {1, 2, 6, 10, 11, 15};
        int arr3[] = {3, 4, 1, 1};
        System.out.println("smallest Integer=>" + smallestPositiveInteger(arr1));
        System.out.println("smallest Integer=>" + smallestPositiveInteger(arr2));
        System.out.println("smallest Integer=>" + smallestPositiveInteger(arr3));
    }


    public static int smallestPositiveInteger(int arr[]){
        Arrays.sort(arr);
        int res = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > res) return res;
            res+= arr[i];
        }
        return res;
    }





}
