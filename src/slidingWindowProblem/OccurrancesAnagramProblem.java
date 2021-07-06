package slidingWindowProblem;

public class OccurrancesAnagramProblem {

	public static void main(String[] args) {
		
		String text = "forxxorfxdofr";
		String patt = "for";
		
		
		System.out.println( countAnagramOccurances(text, patt) );
		
	}
	
	public static int countAnagramOccurances(String text, String patt) {
		int n = text.length();
		int k = patt.length();
		
		int pattArray[] = new int[26];
		
		for(int i=0; i<k; i++) {
			pattArray[patt.charAt(i)-'a']++;
		}
		int ans = 0;
		int i=0, j=0;
		int windowArray[] = new int[26];
		while(j<n) {
			windowArray[text.charAt(j)-'a']++;
			
			if(j-i+1 < k) {
				j++;
			}else if( j-i+1 == k ) {
				ans += checkAnagram(windowArray, pattArray);
				windowArray[text.charAt(i)-'a']--;
				i++;
				j++;
			}	
		}
				
		return ans;
	}
	
	public static int checkAnagram(int []arr1, int []arr2) {
		for(int i=0; i<26; i++) {
			if(arr1[i] != arr2[i]) {
				return 0;
			}
		}
		return 1;
	}

}
