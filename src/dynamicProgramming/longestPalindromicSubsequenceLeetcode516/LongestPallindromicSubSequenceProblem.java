package dynamicProgramming.longestPalindromicSubsequenceLeetcode516;

public class LongestPallindromicSubSequenceProblem {

	public static void main(String[] args) {
		
		String s1 = "agbcba";
		String s2 = new StringBuilder(s1).reverse().toString();
		
		int l = LCSTopDown(s1, s2, s1.length(), s2.length());
		
		System.out.println("Longest Pallindromic SubSequence is equal to lcs of s1 and reverse of s1 = " + l);
		
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

}
