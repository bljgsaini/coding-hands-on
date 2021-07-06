package recursion;

public class PermutationWithCaseChange {
	
	public static void main(String args[]) {
		
		solve("ab", "");
	}
	
	public static void solve(String input, String output) {
		if(input.isEmpty()) {
			System.out.println(output);
			return;
		}
		
		char ch = input.charAt(0);
	
			solve(input.substring(1), (output + String.valueOf(ch)) );
			solve(input.substring(1), (output + String.valueOf(ch).toUpperCase()) );
		
	}
	
}
