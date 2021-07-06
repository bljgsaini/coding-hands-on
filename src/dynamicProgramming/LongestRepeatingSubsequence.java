package dynamicProgramming;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		String s = "AABFBCDD";
		System.out.println(longestRepeatingSubsequense(s, s.length()));
		
	}
	
	public static int longestRepeatingSubsequense(String s, int n) {
		
		int t[][] = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			t[i][0] = 0;
			t[0][i] = 0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i != j && s.charAt(i-1) == s.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		
		return t[n][n];
	}

}
