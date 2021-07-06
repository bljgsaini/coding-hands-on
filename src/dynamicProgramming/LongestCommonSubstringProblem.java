package dynamicProgramming;

public class LongestCommonSubstringProblem {
	
	public static int t[][] = new int[101][101];

	public static void main(String[] args) {
		
		String s1 = "Site:Geeks";
		String s2 = "NewSite:GeeksQ";
		
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				t[i][j] = -1;
			}
		}
		
		System.out.println("LCS is = " + longestCommonSubstringRec(s1, s2, s1.length(), s2.length(), 0));

	}
	
	public static int longestCommonSubstringRec(String s1, String s2, int m, int n, int count) {
		
		if(m == 0 || n == 0) {
			return count;
		}
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			count = longestCommonSubstringRec(s1, s2, m-1, n-1, count+1);
		}
		count = Math.max(count, Math.max(longestCommonSubstringRec(s1, s2, m-1, n,0), longestCommonSubstringRec(s1, s2, m, n-1,0)));
		
		return count;
		
	}
	
	public static int longestCommonSubString(String s1, String s2, int m, int n) {
		
		int t[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			t[i][0] = 0;
		}
		for(int i=0; i<=n; i++) {
			t[0][i] = 0;
		}
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
					ans = Math.max(ans, t[i][j]);
				}else {
					t[i][j] = 0;
				}
				
			}
		}
		return ans;
	}

}
