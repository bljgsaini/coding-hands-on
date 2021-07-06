package recursion;

public class PermutationWithSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "ABC";
		String output = "";
		solve(str.substring(1), output + String.valueOf(str.charAt(0)));

	}
	
	
	public static void solve(String input, String output) {
		if(input.isEmpty()) {
			System.out.println(output);
			return;
		}
		
		char ch = input.charAt(0);
	
		solve(input.substring(1), (output + String.valueOf(ch)) );
		solve(input.substring(1), (output +"_"+ String.valueOf(ch)) );
		
	}
	

}
