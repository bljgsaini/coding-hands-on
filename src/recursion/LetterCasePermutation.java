package recursion;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		solve("a1b2", "");

	}
	
	
	
	public static void solve(String input, String output) {
		if(input.isEmpty()) {
			System.out.println(output);
			return;
		}
		
		char ch = input.charAt(0);
		int num = ch-'0';
		
		if(num >= 0 && num <= 9) {
			solve(input.substring(1), (output + String.valueOf(ch)));
		}else {
			solve(input.substring(1), (output + String.valueOf(ch).toUpperCase()) );
			solve(input.substring(1), (output + String.valueOf(ch).toLowerCase()) );
		}
		
	}
	

}
