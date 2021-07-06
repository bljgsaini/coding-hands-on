package dynamicProgramming;

public class ShortestCommonSuperSequenceProblem {

	public static void main(String[] args) {
		
		
		String s1 = "ACZXD";
		String s2 = "AZGHYID";
		
		int l = LCSTopDown(s1, s2, s1.length(), s2.length());
		
		System.out.println( (s1.length() + s2.length() - l) );
		
		System.out.println( printShortestCommonSuperSequence(s1, s2, s1.length(), s2.length()));
		
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
	
	public static String printShortestCommonSuperSequence(String s1, String s2, int m, int n) {
		
		//System.out.println("temp");
		
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
		
		while( i>0 && j >0 ) {
			//System.out.println("temp2");
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				ans+= String.valueOf(s1.charAt(i-1));
				i--;
				j--;
			}else {
				if(t[i][j-1] > t[i-1][j]) {
					ans += String.valueOf(s2.charAt(j-1));
					j--;
				}else {
					ans += String.valueOf(s1.charAt(i-1));
					i--;
				}
			}	
		}
		
		while(i>0) {
			ans+= String.valueOf(s1.charAt(i-1));
			i--;
		}
		
		while(j>0) {
			ans += String.valueOf(s2.charAt(j-1));
			j--;
		}
		
		return ans;
	}

}
