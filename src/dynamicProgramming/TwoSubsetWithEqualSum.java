package dynamicProgramming;

import java.util.Iterator;
import java.util.Stack;

public class TwoSubsetWithEqualSum {

    public static void main(String[] args) {

        int arr[] = {5,7,1,6,2,6,3};
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+= arr[i];
        }
        if(sum%2 == 1) {
            System.out.println("No subset available");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        boolean flag = getSubsetWithSumK(arr, 0, sum/2, stack);
        if(flag){
            System.out.println("Subset is");
            Iterator value = stack.iterator();
            while(value.hasNext()){
                System.out.print(value.next() + " ");
            }
            return;
        }

        System.out.println("No subset available");
    }


    public static boolean getSubsetWithSumK(int arr[], int i, int sum, Stack<Integer> stack){
        if(sum == 0) return true;
        if( i >= arr.length ) return false;

        if(arr[i] <= sum ){
            stack.push(arr[i]);
            boolean flag = getSubsetWithSumK(arr, i+1, sum-arr[i], stack);
            if(flag) return true;
            stack.pop();
            return getSubsetWithSumK(arr, i+1, sum, stack);
        }
        return getSubsetWithSumK(arr, i+1, sum, stack);
    }

}
