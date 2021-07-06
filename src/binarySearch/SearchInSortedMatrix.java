package binarySearch;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void findElementInMatrix(int arr[][], int key) {
		
		int m = arr.length;
		int n = arr[0].length;
		
		int i= 0, j = n-1;
		
		while(i >=0 && i < n && j>=0 && j<m) {
			
			if(arr[i][j] == key) {
				System.out.println(i + " " + j);
				return;
			}
			
			if(arr[i][j] > key) {
				j--;
			}else if(arr[i][j] < key) {
				i++;
			}
			
		}
		
		System.out.println("-1");
		
	}

}
