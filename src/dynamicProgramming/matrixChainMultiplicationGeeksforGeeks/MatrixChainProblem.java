package dynamicProgramming.matrixChainMultiplicationGeeksforGeeks;


//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1/#
public class MatrixChainProblem {

	public static void main(String[] args) {

		int arr[] = {40, 20, 30, 10, 30};
		System.out.println("min cost => "+ matrixMultiplication(arr.length, arr));

	}

	static int t[][] = new int[1000][1000];

	static int matrixMultiplication(int N, int arr[]){
		for(int i=0; i<=N; i++){
			for(int j=0; j<=N; j++){
				t[i][j] = -1;
			}
		}
		return matrixMultiplicationUtil(arr, 1, N-1);
	}

	static int matrixMultiplicationUtil(int arr[], int start, int end){
		if(start >= end ) return 0;

		if(t[start][end] != -1) return t[start][end];

		int ans = Integer.MAX_VALUE;
		for(int k = start; k<=end-1; k++){
			int temp = matrixMultiplicationUtil(arr, start, k) + matrixMultiplicationUtil(arr, k+1, end) + arr[start-1]*arr[k]*arr[end];
			ans = Math.min(ans, temp);
		}

		t[start][end] = ans;
		return ans;
	}

}
