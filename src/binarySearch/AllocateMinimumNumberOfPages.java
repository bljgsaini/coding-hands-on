package binarySearch;

public class AllocateMinimumNumberOfPages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {10, 20, 30, 40};
		int k = 2;
		System.out.println(solve(arr, k));
		
	}
	
	
	
	// https://www.geeksforgeeks.org/allocate-minimum-number-pages/
	public static int solve(int arr[], int k) {
		
		int low = 0;
		int high = 0;
		
		for(int i=0; i<arr.length; i++) {
			high += arr[i];
		}
		
		int result = -1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(isValid(arr, k, mid)) {
				result = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}	
		}
		
		return result;
	}
	
	public static boolean isValid(int arr[], int k, int max) {
		
		int count = 1;
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum+= arr[i];
			
			if(sum > max ) {
				count++;
				sum = arr[i];
			}
			
		}
		
		if(count == k) return true;
		return false;
		
	}

}
