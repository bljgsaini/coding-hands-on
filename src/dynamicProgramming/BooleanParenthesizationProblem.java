package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;


//https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1/#
public class BooleanParenthesizationProblem {

	public static void main(String[] args) {
		String s = "T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T";
		System.out.println("number of ways=>" + countWays(s.length(),s ));
	}


	static Map<String, Integer> map;

	static int countWays(int N, String S) {
		map = new HashMap();
		return countWaysUtil(S, 0, N - 1, true) % 1003;
	}

	static int countWaysUtil(String str, int start, int end, boolean isTrue) {

		if (start > end) return 0;
		if (start == end) {
			if (isTrue) {
				if (str.charAt(start) == 'T') return 1;
				else return 0;
			} else {
				if (str.charAt(start) == 'F') return 1;
				else return 0;
			}
		}

		String key = start + String.valueOf(isTrue) + end;
		if (map.containsKey(key)) return map.get(key);


		int ans = 0;

		for (int i = start + 1; i < end; i += 2) {
			int leftTrue = countWaysUtil(str, start, i - 1, true);
			int leftFalse = countWaysUtil(str, start, i - 1, false);
			int rightTrue = countWaysUtil(str, i + 1, end, true);
			int rightFalse = countWaysUtil(str, i + 1, end, false);

			char ch = str.charAt(i);

			if (ch == '^') {
				if (isTrue) {
					ans += leftTrue * rightFalse + leftFalse * rightTrue;
				} else {
					ans += leftTrue * rightTrue + leftFalse * rightFalse;
				}

			} else if (ch == '&') {
				if (isTrue) {
					ans += leftTrue * rightTrue;
				} else {
					ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
				}

			} else if (ch == '|') {
				if (isTrue) {
					ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
				} else {
					ans += leftFalse * rightFalse;
				}

			}

		}

		map.put(key, ans % 1003);

		return map.get(key);


	}


	static int t[][][] = new int[100][100][2];

	public int solveDP(String str, int i, int j, int isTrue) {

		if (j < i) return 0;

		if (i == j) {
			if (isTrue == 1) {
				return str.charAt(i) == 'T' ? 1 : 0;
			} else {
				return str.charAt(i) == 'F' ? 1 : 0;
			}
		}

		if (t[i][j][isTrue] != -1) {
			return t[i][j][isTrue];
		}

		int ans = 0;
		for (int k = i + 1; k <= j - 1; k += 2) {

			int leftT = solveDP(str, i, k - 1, 1);
			int leftF = solveDP(str, i, k - 1, 0);
			int rightT = solveDP(str, k + 1, j, 1);
			int rightF = solveDP(str, k + 1, j, 0);

			if (str.charAt(k) == '&') {
				if (isTrue == 1) {
					ans += leftT * rightT;
				} else {
					ans += leftT * rightF + leftF * rightT + leftF * rightF;
				}
			} else if (str.charAt(k) == '|') {
				if (isTrue == 1) {
					ans += leftT * rightT + leftT * rightF + leftF * rightT;
				} else {
					ans += leftF * rightF;
				}
			} else if (str.charAt(k) == '^') {
				if (isTrue == 1) {
					ans += leftT * rightF + leftF * rightT;
				} else {
					ans += leftF * rightF + leftT * rightT;
				}
			}
		}

		t[i][j][isTrue] = ans%1003;

		return ans%1003;

	}


}