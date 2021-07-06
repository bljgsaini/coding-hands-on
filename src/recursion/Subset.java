package recursion;

public class Subset {

	public static void main(String[] args) {
		
		solve("ABC", 0, "");

	}
	
	
	public static void solve(String input, int i, String output) {
		
		if( i== input.length()) {
			System.out.println(output);
			return ;
		}
		
		solve(input, i+1, output);
		solve(input, i+1, output+String.valueOf(input.charAt(i)));
		
	}

}
