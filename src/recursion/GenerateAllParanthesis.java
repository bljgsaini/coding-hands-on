package recursion;

public class GenerateAllParanthesis {

	public static void main(String[] args) {
		
		solve("", 4,4);

	}
	
	public static void solve(String op, int open, int close) {
		
		if(open == 0 && close == 0) {
			System.out.println(op);
			return;
		}
		
		if(open!=0) {
			solve(op + "(", open-1, close);
		}
		if(close > open) {
			solve(op+")", open, close-1);
		}
		
		
	}
	

}
