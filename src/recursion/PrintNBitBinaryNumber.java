package recursion;

public class PrintNBitBinaryNumber {

	public static void main(String[] args) {
		
		solve("", 0, 0, 4);
		
	}
	
	
	public static void solve(String op, int ones, int zeros, int N) {
		
		if(ones + zeros == N ) {
			System.out.println(op);
			return ;
		}
		
		if(ones == zeros ) {
			solve(op+"1", ones+1, zeros, N);
		}else if(ones > zeros){
			solve(op+"0", ones, zeros+1, N);
			solve(op+"1", ones+1, zeros, N);
		}
		
	}
	
}
