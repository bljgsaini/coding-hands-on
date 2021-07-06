package binarySearch;

public class PeakElement {

	public static void main(String[] args) {
		
		int arr[] = {5,10,20,30,40};
		
		System.out.println(findPeak(arr));

	}
	
	public static int findPeak(int arr[]) {
		int n = arr.length;
		int low = 0; 
		int high = n-1;
		
		while(low<= high) {
			
			int mid = low + (high-low)/2;
			
			if(mid == 0 || mid == n-1 ) {
				return arr[mid];
			}
			if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
				return arr[mid];
			}
			
			if(arr[mid] < arr[mid+1]) {
				low = mid+1;
			}else if(arr[mid] < arr[mid-1]) {
				high = mid-1;
			}
			
		}
		
		return -1;
		
	}

}
