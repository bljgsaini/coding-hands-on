package string;

public class StringProblems {

	public static void main(String[] args) {
		
		String str1 = "ABABDABACDABABCABAB";
		String str2 = "ABABCABAB";
		
		KMPSearch(str1, str2);
		
	}
	
	
	public static void KMPSearch(String text, String patt) {
		
		int m = patt.length();
		int n = text.length();
			
		int lps[] = createLPSArray(patt);
		
		int j = 0, i = 0;
		
		while(i < n) {
			if(text.charAt(i) == patt.charAt(j)) {
				i++;
				j++;
			}
			if(j == m) {
				System.out.println("Pattern found at : " + (i-j) );
				j = lps[j-1];
			}else {
				if(i < n && text.charAt(i) != patt.charAt(j)) {
					if(j != 0) {
						j = lps[j-1];
					}else {
						i++;
					}
				}
			}
						
		}
		
		
	}
	
	public static int[] createLPSArray(String s) {
		int j= 0, i = 1;
	    int n = s.length();
	    int[] arr = new int[n];
	    
	    arr[0] = 0;
	    
	    while(i < n){
	        if(s.charAt(i) == s.charAt(j)){
	            arr[i] = j+1;
	            i++;
	            j++;
	        }else{
	            if(j != 0){
	                j = arr[j-1];
	            }else{
	            	arr[i] = 0;
	                i++;
	                
	            }
	        }
	    }
	    return arr;
	}
	
	public static int lps(String s)
	{
	    int j= 0, i = 1;
	    int n = s.length();
	    int[] arr = new int[n];
	    
	    arr[0] = 0;
	    
	    while(i < n){
	        if(s.charAt(i) == s.charAt(j)){
	            arr[i] = j+1;
	            i++;
	            j++;
	        }else{
	            if(j != 0){
	                j = arr[j-1];
	            }else{
	            	arr[i] = 0;
	                i++;
	                
	            }
	        }
	    }
	    
	    
	    return arr[n-1];
	    
	}

}
