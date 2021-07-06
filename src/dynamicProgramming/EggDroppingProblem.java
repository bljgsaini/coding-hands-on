package dynamicProgramming;

public class EggDroppingProblem {

	public static void main(String[] args) {
		
		System.out.println("minimum number of of trials in worst case =" + solve(2, 4));

	}
	
	
	public static int solve(int e, int f) {
		
		if(f==0 || f == 1 ) return f;
		
		if( e == 1 ) return f;
		
		int ans = Integer.MAX_VALUE;
		
		for(int k=1; k<=f; k++) {
			
			int tempAns = 1 + Math.max(solve(e-1, k-1), solve(e, f-k));
			
			ans = Math.min(ans, tempAns);
			
		}
		
		return ans;
		
	}

}
