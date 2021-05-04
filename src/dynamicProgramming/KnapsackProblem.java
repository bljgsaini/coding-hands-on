package dynamicProgramming;

public class KnapsackProblem {

	public static void main(String[] args) {
		
		
       
	}
	
	
	
	public int countSubSetSum(int arr[], int n, int sum){
		
		/*
		 * if(n == 0){ if(sum == 0)return 1; return 0; } if(arr[n-1] <= sum){ return
		 * countSubSetSum(arr, n-1, sum-arr[n-1]) + countSubSetSum(arr, n-1, sum); }
		 * return countSubSetSum(arr, n-1, sum);
		 */
	
        int t[][] = new int[n+1][sum+1];
                
        for(int j=0; j<sum+1; j++){
            t[0][j] = 0;
        }
        
        for(int i=0; i<n+1; i++){
            t[i][0] = 1;
        }
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                } 
            }
        }
        return t[n][sum];
	}
}
