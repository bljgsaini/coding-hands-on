package twoPointer;

//977. Squares of a Sorted Array
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int [] nums = {-2, -1, 0, 1,2,3,4,5,6,7};
        int [] ans = sortedSquares(nums);
        for(int num : ans ){
            System.out.print(num + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length; int firstPosIndex = n; int lastNegIndex = -1; int low = 0; int high = n-1;
        // find the first positive index
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > 0 ) {
                firstPosIndex = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        lastNegIndex = firstPosIndex - 1; int ans[] = new int[n]; int k = 0;

        while(lastNegIndex >= 0 || firstPosIndex < n){
            if(lastNegIndex >= 0 && firstPosIndex < n){
                if(Math.abs(nums[lastNegIndex]) <= nums[firstPosIndex]){
                    ans[k] = nums[lastNegIndex]*nums[lastNegIndex];
                    k++;
                    lastNegIndex--;
                }else{
                    ans[k] = nums[firstPosIndex]*nums[firstPosIndex];
                    k++;
                    firstPosIndex++;
                }
            }else if(lastNegIndex >= 0){
                ans[k] = nums[lastNegIndex]*nums[lastNegIndex];
                k++;
                lastNegIndex--;
            }else{
                ans[k] = nums[firstPosIndex]*nums[firstPosIndex];
                k++;
                firstPosIndex++;
            }
        }
        return ans;
    }

}
