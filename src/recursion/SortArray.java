package recursion;

public class SortArray {

	public static void main(String[] args) {
		
		int arr[] = {1,5,0,2};
		int n = arr.length;
		
		sort(arr, n-1);
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i] + " ");
		}

	}
	
	
	public static void sort(int arr[], int n) {
		//base condition
		if(n == 0 ) return ;
		
		//Hypothesis
		sort(arr, n-1);
		
		//induction
		insert(arr, n);
		
	}
	
	
	public static void insert(int arr[], int n) {
		
		if(n == 0 ) return ;
		if(arr[n] > arr[n-1]) return;
		
		if(arr[n] < arr[n-1]) {
			int temp = arr[n];
			arr[n] = arr[n-1];
			arr[n-1] = temp;
		}
		
		insert(arr, n-1);
		
	}

}
