package dynamicProgramming;

public class MatrixChainProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int t[][] = new int[1000][1000];
	
	public static int solve(int arr[], int i, int j) {
		
		if(j<=i) return 0;
		
		if(t[i][j] != -1) return t[i][j];
		
		int ans  = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tempAns = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
			ans = Math.min(ans, tempAns);
		}
		t[i][j] = ans;
		return ans;
	}

}
