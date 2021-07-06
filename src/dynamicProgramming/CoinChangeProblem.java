package dynamicProgramming;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int coin[] = {1, 2, 3};
		
		//System.out.println("number of ways coin can be changed " + coinChangeProblemTopDown(coin, 3, 5));
		System.out.println("number of ways coin can be changed " + minCoinChangeProblemRec(coin, 3, 5));
		
		
	}
	
	
	public static int coinChangeProblemRec(int coin[], int n, int sum) {
		
		//base condition
		if(sum == 0) return 1;
		if(n == 0 ) return 0;
		
		if(coin[n-1] <= sum) {
			return coinChangeProblemRec(coin, n, sum-coin[n-1]) + coinChangeProblemRec(coin, n-1, sum);
		}
		return coinChangeProblemRec(coin, n-1, sum);
		
	}
	
	public static int coinChangeProblemTopDown(int coin[], int n, int sum) {
		
		int t[][] = new int[n+1][sum+1];
			
		for(int j=0; j<= sum; j++) {
			t[0][j] = 0;
		}
		
		for(int i=0; i<=n; i++) {
			t[i][0] = 1;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(coin[i-1] <= j ) {
					t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
		
	}
	
	public static int minCoinChangeProblem(int coin[], int n, int sum) {
		
		int t[][] = new int[n+1][sum+1];
		
		for(int i=0; i<=n; i++) {
			t[i][0] = 0;
		}
		
		for(int j=0; j<=sum; j++) {
			t[0][j] = Integer.MAX_VALUE -1;
		}
		
		for(int j=1; j<=sum; j++) {
			if( j % coin[0] == 0 ) {
				t[1][j] = j/coin[0];
			}else {
				t[1][j] = Integer.MAX_VALUE -1;
			}
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(coin[i-1] <= j) {
					t[i][j] = Math.min(t[i][j-coin[i-1]]+1 , t[i-1][j] );
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][sum];
	
	}
	
	
public static int minCoinChangeProblemRec(int coin[], int n, int sum) {
		
		if(sum == 0) return 0;
		
		if(n ==1 ) {
			if(sum % coin[n-1] == 0) {
				return sum/coin[n-1];
			}else {
				return Integer.MAX_VALUE - 1;
			}
		}
		
		if(coin[n-1] <= sum) {
			return Math.min(  1+ minCoinChangeProblemRec(coin, n, sum-coin[n-1]), minCoinChangeProblemRec(coin, n-1, sum) );
		}
		return minCoinChangeProblemRec(coin, n-1, sum);
	
	}

}
