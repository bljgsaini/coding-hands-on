package dynamicProgramming;

public class MinJumpsToReachEndProblem {

	public static void main(String[] args) {
		int arr[] = {1,3,5,8,9,2,6,7,6,8,9};
		//int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		//int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		System.out.println( minJumpMaxReach(arr, arr.length));
	}
	
	public static int minJump(int arr[], int start, int end) {
		
		if(end <= start ) return 0;
		if( arr[start] == 0 ) return Integer.MAX_VALUE;
		
		int ans = Integer.MAX_VALUE;
		for(int i=start+1; i<= start + arr[start] ; i++) {
			
			int jumps = minJump(arr, i, end);
			if(jumps != Integer.MAX_VALUE && jumps +1 < ans ) {
				ans = jumps + 1;
			}
		}
		return ans;
	}
	
	public static int minJumpDP(int arr[], int n) {
		int jumps[] = new int[n];
		
		jumps[0] = 0;
		
		for(int i=1; i<n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for(int j=0; j<i; j++) {
				if( i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE ) {
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		
		return jumps[n-1];
	}
	
	
	// o(n) solution
	
	public static int minJumpMaxReach(int arr[], int n) {
		
		int maxReach = arr[0];
		int steps = arr[0];
		int jumps = 1;
		
		for(int i=1; i<n; i++) {
			
			if(i== n-1) return jumps;
			
			maxReach = Math.max(maxReach, i+arr[i]);
			
			steps--;
			
			if(steps == 0) {
				jumps++;
				if(i > maxReach) {
					return -1;
				}
				steps = maxReach-i;
			}
			
		}
		
		return jumps;
	}

}
