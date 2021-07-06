package recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		
		solve(32, 1,2,3);
		
		System.out.println("end");
		

	}
	
	public static void solve(int n, int s, int d, int h) {
		
		if(n == 1 ) {
			System.out.println("Move plate from " + s + " to " + d);
			return ;
		}
		
		solve(n-1, s, h, d);
		
		System.out.println("Move plate from " + s + " to " + d);
		
		solve(n-1, h, d, s);
		
	}
	

}
