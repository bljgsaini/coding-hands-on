package dynamicProgramming;

public class PallindromePartitioningProblem {

	public static void main(String[] args) {
		
	}
	
	
	static int t[][] = new int[1000][1000];
	
	public static int solve(String str, int i, int j) {
		
		if(j <= i ) return 0;
		if(isPallindrome(str, i,j) == true) return 0;
		
		if(t[i][j]!= -1) return t[i][j];
		int max = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++) {
			int tempAns = 1 + solve(str, i, k) + solve(str, k+1, j);
			max = Math.max(max, tempAns);
		}
		
		t[i][j] = max;
		
		return max;
	}
	
	
public static int optimizedSolve(String str, int i, int j) {
		
		if(j <= i ) return 0;
		if(isPallindrome(str, i,j) == true) return 0;
		
		if(t[i][j]!= -1) return t[i][j];
		int max = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++) {
			
			int left, right;
			
			if(t[i][k] != -1) {
				left = t[i][k];
			}else {
				left = solve(str, i, k);
				t[i][k] = left;
			}
			
			if(t[k+1][j] != -1) {
				right = t[k+1][j];
			}else {
				right = solve(str, k+1, j);
				t[k+1][j] = right;
			}
			
			int tempAns = 1 + left + right;
			max = Math.max(max, tempAns);
		}
		
		t[i][j] = max;
		
		return max;
	}
	
	
	public static boolean isPallindrome(String str, int i, int j) {
		if(j<= i) return true;
		while(i<j) {
			if(str.charAt(i)!= str.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

}
