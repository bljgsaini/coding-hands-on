package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesizationProblem {

	public static void main(String[] args) {

	}
	
	
	
	Map<String, Integer> map = new HashMap<>();
	
	public int solveDPWithMap(String str, int i, int j, int isTrue) {
		
		if(j < i ) return 0;
		
		if( i== j ) {
			if(isTrue == 1) {
				return str.charAt(i) == 'T' ? 1 : 0;
			}else {
				return str.charAt(i) == 'F' ? 1 : 0;
			}
		}
		
		String key = i+" "+j+" "+isTrue;
		if(map.containsKey(key)) return map.get(key);
		
		int ans = 0;
		for(int k=i+1; k<=j-1; k+=2) {
			
			int leftT = solveDPWithMap(str, i, k-1, 1);
			int leftF = solveDPWithMap(str, i, k-1, 0);
			int rightT = solveDPWithMap(str, k+1, j, 1);
			int rightF = solveDPWithMap(str, k+1, j, 0);
			
			if(str.charAt(k)== '&') {
				if(isTrue == 1) {
					ans += leftT*rightT;
				}else {
					ans += leftT*rightF + leftF*rightT + leftF*rightF;
				}
			}else if(str.charAt(k) == '|') {
				if(isTrue == 1) {
					ans += leftT*rightT + leftT*rightF + leftF*rightT;
				}else {
					ans += leftF*rightF;
				}
			}else if(str.charAt(k) == '^') {
				if(isTrue == 1) {
					ans+= leftT*rightF + leftF*rightT;
				}else {
					ans += leftF*rightF + leftT*rightT;
				}
			}
		}
		
		map.put(key, ans);
		
		return ans;	
		
	}
	
	
	static int t[][][] = new int[100][100][2];
	
	public int solveDP(String str, int i, int j, int isTrue) {
		
		if(j < i ) return 0;
		
		if( i== j ) {
			if(isTrue == 1) {
				return str.charAt(i) == 'T' ? 1 : 0;
			}else {
				return str.charAt(i) == 'F' ? 1 : 0;
			}
		}
		
		if(t[i][j][isTrue] != -1) {
			return t[i][j][isTrue];
		}
		
		int ans = 0;
		for(int k=i+1; k<=j-1; k+=2) {
			
			int leftT = solveDP(str, i, k-1, 1);
			int leftF = solveDP(str, i, k-1, 0);
			int rightT = solveDP(str, k+1, j, 1);
			int rightF = solveDP(str, k+1, j, 0);
			
			if(str.charAt(k)== '&') {
				if(isTrue == 1) {
					ans += leftT*rightT;
				}else {
					ans += leftT*rightF + leftF*rightT + leftF*rightF;
				}
			}else if(str.charAt(k) == '|') {
				if(isTrue == 1) {
					ans += leftT*rightT + leftT*rightF + leftF*rightT;
				}else {
					ans += leftF*rightF;
				}
			}else if(str.charAt(k) == '^') {
				if(isTrue == 1) {
					ans+= leftT*rightF + leftF*rightT;
				}else {
					ans += leftF*rightF + leftT*rightT;
				}
			}
		}
		
		t[i][j][isTrue] = ans;
		
		return ans;	
		
	}
	
	
public int solve(String str, int i, int j, int isTrue) {
		
		if(j < i ) return 0;
		
		if( i== j ) {
			if(isTrue == 1) {
				return str.charAt(i) == 'T' ? 1 : 0;
			}else {
				return str.charAt(i) == 'F' ? 1 : 0;
			}
		}
		
		int ans = 0;
		
		for(int k=i+1; k<=j-1; k+=2) {
			
			int leftT = solve(str, i, k-1, 1);
			int leftF = solve(str, i, k-1, 0);
			int rightT = solve(str, k+1, j, 1);
			int rightF = solve(str, k+1, j, 0);
			
			if(str.charAt(k)== '&') {
				if(isTrue == 1) {
					ans += leftT*rightT;
				}else {
					ans += leftT*rightF + leftF*rightT + leftF*rightF;
				}
			}else if(str.charAt(k) == '|') {
				if(isTrue == 1) {
					ans += leftT*rightT + leftT*rightF + leftF*rightT;
				}else {
					ans += leftF*rightF;
				}
			}else if(str.charAt(k) == '^') {
				if(isTrue == 1) {
					ans+= leftT*rightF + leftF*rightT;
				}else {
					ans += leftF*rightF + leftT*rightT;
				}
			}
		}
		
		return ans;	
		
	}

}
