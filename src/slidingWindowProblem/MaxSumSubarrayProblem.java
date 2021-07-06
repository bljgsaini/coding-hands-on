package slidingWindowProblem;

public class MaxSumSubarrayProblem {

	public static void main(String[] args) {
		
		int arr[] = {1 ,2, 3, 4, 5, 6};
		
		System.out.println(maxSubArraySum(arr, 3));

	}
	
	public static int maxSubArraySum(int arr[], int k) {
		
		int n = arr.length;
		int i=0, j=0;
		
		int ans = Integer.MIN_VALUE;
		int tempSum = 0;
		while(j< n) {
			tempSum += arr[j];
			if(j-i+1 < k) {
				j++;
			}else if(j-i+1 == k) {
				ans = Math.max(ans, tempSum);
				tempSum -= arr[i];
				i++;
				j++;
			}
			
		}	
		return ans;
	}

}
