package dynamicProgramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s = "zxabcdezy";
		String s2 = "yzabcdezxy";
		
		System.out.println("print LCS is = " + printLCS(s, s2, s.length(), s2.length()));

	}
	
	
	public static int LCSRecursive(String s1, String s2, int m, int n) {
		
		if(m == 0 || n == 0 ) return 0;
		
		if(s1.charAt(m-1) == s2.charAt(n-1) ) {
			return 1 + LCSRecursive(s1, s2, m-1, n-1);
		}
	
		return Math.max( LCSRecursive(s1, s2, m-1, n) , LCSRecursive(s1, s2, m, n-1));
	
	}
	
	public static int LCSBottomUp(String s1, String s2, int m, int n) {
		
		/*
		 * int t[][] = new t[m+1][n+1]; for(int i=0; i<=m; i++) { for(int j=0; j<=n;
		 * j++) { t[i][j] = -1; } }
		 */
		
		if(m == 0 || n == 0 ) return 0;
		// if( t[m][n] != -1 ) return t[m][n];
		if(s1.charAt(m-1) == s2.charAt(n-1) ) {
			return 1 + LCSRecursive(s1, s2, m-1, n-1); // t[m][n] = ?
		}
	
		return Math.max( LCSRecursive(s1, s2, m-1, n) , LCSRecursive(s1, s2, m, n-1));// t[m][n] = ?
		
		//return t[m][n];
	}
	
	public static int LCSTopDown(String s1, String s2, int m, int n) {
		
		int t[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			t[i][0] = 0;
		}
		for(int i=0; i<=n; i++) {
			t[0][i] = 0;
		}
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		return t[m][n];
	}
	
	
	public static String printLCS(String s1, String s2, int m, int n) {
		
		int t[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			t[i][0] = 0;
		}
		for(int i=0; i<=n; i++) {
			t[0][i] = 0;
		}
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		
		int i = m, j = n;
		String ans = "";
		while(i>0 && j > 0) {
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				ans += String.valueOf(s1.charAt(i-1));
				i--;
				j--;
			}else {
				if(t[i][j-1] > t[i-1][j]) {
					j--;
				}else {
					i--;
				}
			}
			
		}
		
		return new StringBuilder(ans).reverse().toString();
	}

}
