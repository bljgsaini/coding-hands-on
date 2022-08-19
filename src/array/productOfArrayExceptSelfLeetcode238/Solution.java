package array.productOfArrayExceptSelfLeetcode238;

//https://leetcode.com/problems/product-of-array-except-self/
public class Solution {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int rightProduct[] = new int[n];
        int prevProduct= 1;
        for(int i=n-1; i>=0; i--){
            rightProduct[i] = prevProduct;
            prevProduct*= nums[i];
        }

        int ans[] = new int[n];
        ans[0] = rightProduct[0];
        int leftProduct = nums[0];
        for(int i=1; i<n; i++){
            ans[i] = leftProduct*rightProduct[i];
            leftProduct*= nums[i];
        }
        return ans;
    }

}
