package dynamicProgramming;

public class RodCuttingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxRodCuttingPrice(int prices[], int len[], int n, int maxLen) {
		
		if(maxLen == 0 ) return 0;		
		if(n == 0 ) return 0;
		
		if(len[n-1] <= maxLen) {
			return Math.max( prices[n-1] + maxRodCuttingPrice(prices, len, n, maxLen-len[n-1]), maxRodCuttingPrice(prices, len, n-1, maxLen) );
		}
		return maxRodCuttingPrice(prices, len, n-1, maxLen);
		
	}
	
	
	public static int maxRodCuttingPriceTopDown(int prices[], int len[], int n, int maxLen) {
		
		int t[][] = new int[n+1][maxLen];
		
		for(int i=0; i<=n; i++) {
			t[i][0] = 0;
		}
		
		for(int i=0; i<=maxLen; i++) {
			t[0][i] = 0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=maxLen; j++) {
				if(len[i-1] <= j) {
					t[i][j] = Math.max(prices[i-1]+t[i][j-len[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][maxLen];
	}

}
