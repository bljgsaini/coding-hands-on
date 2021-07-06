package slidingWindowProblem;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println( minimumWindowSubString("TOTMTAPTA", "TTA") );
	}
	
	
	public static String minimumWindowSubString(String str, String text) {

        Map< Character, Integer> map = new HashMap<>();
        for(int i=0; i<text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0)+1);
        }

        int i=0, j=0;
        int n = str.length();
        int count = map.size();
        int min = Integer.MAX_VALUE;
        int start = -1, end = -1;

        while(j< n) {
        	
            char ch = str.charAt(j);
            if(map.containsKey(ch)) {
                int num = map.get(ch);
                if(num-1 == 0) {
                    count--;
                }
                map.put(ch, num-1);
            }

            if(count == 0) {
                while(count == 0) {
                    if(min > j-i+1) {
                        min = j-i+1;
                        start = i;
                        end = j;
                    }
                    ch = str.charAt(i);
                    if(map.containsKey(ch)) {
                        int num = map.get(ch);
                        if(num + 1 > 0 ) {
                            count++;
                        }
                        map.put(ch, num+1);
                    }
                    i++;
                }
            }
            j++;
        }

        return start == -1 ? "" : str.substring(start, end+1);

    }
	
	public static int minimumWindowSubStringSize(String str, String text) {
		
		Map< Character, Integer>map = new HashMap<>();
		for(int i=0; i<text.length(); i++) {
			map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0)+1);
		}
		
		int i=0, j=0;
		int n = str.length();
		int count = map.size();
		int min = Integer.MAX_VALUE;
		
		while(j< n) {
			
			char ch = str.charAt(j);
			if(map.containsKey(ch)) {
				int num = map.get(ch);
				if(num-1 == 0) {
					count--;
				}
				map.put(ch, num-1);
			}

			if(count == 0) {
				while(count == 0) {
					min = Math.min(min, j-i+1);
					ch = str.charAt(i);
					if(map.containsKey(ch)) {
						int num = map.get(ch);
						if(num + 1 > 0 ) {
							count++;
						}
						map.put(ch, num+1);
					}
					i++;
				}
			}
			j++;
		}
		
		return min;
	}

}
