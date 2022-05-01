package dynamicProgramming.longestCommonSubsequenceLeetcode1143;

import java.util.HashMap;
import java.util.Map;


//1143. Longest Common Subsequence
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s = "zxabcdezy";
		String s2 = "yzabcdezxy";
		
		System.out.println("print LCS is = " + printLCS(s, s2, s.length(), s2.length()));

	}

	Map<String, Integer> map;

	public int longestCommonSubsequence(String text1, String text2) {
		map = new HashMap();
		return LCSRecursiveDP(text1, text2, text1.length(), text2.length() );
	}
	
	
	public int LCSRecursiveDP(String str1, String str2, int m, int n) {
		if(m == 0 || n== 0 ) return 0;
		if(map.containsKey(m+"#"+n)) return map.get(m+"#"+n);
		if( str1.charAt(m-1) == str2.charAt(n-1) ){
			map.put(m+"#"+n, 1+ LCSRecursiveDP(str1, str2, m-1, n-1) );
			return map.get(m+"#"+n);
		}
		map.put(m+"#"+n, Math.max(LCSRecursiveDP(str1, str2, m, n-1), LCSRecursiveDP(str1, str2, m-1, n)) );
		return map.get(m+"#"+n);
	}

	public int LCSTopDown(String s1, String s2, int m, int n) {

		char[] charArr1 = s1.toCharArray();
		char[] charArr2 = s2.toCharArray();

		int[][] t = new int[m+1][n+1];

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(charArr1[i-1] == charArr2[j-1]) {
					t[i][j] = 1+t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		return t[m][n];
	}
	
	
	public static String printLCS(String s1, String s2, int m, int n) {

		char[] charArr1 = s1.toCharArray();
		char[] charArr2 = s2.toCharArray();

		int[][] t = new int[m+1][n+1];

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(charArr1[i-1] == charArr2[j-1]) {
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
