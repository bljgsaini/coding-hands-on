package slidingWindowProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeIntegerInSubArrayK {

	public static void main(String[] args) {


		int arr[] = {2 ,-1, -7, 8, -15, 30, 13, 28};
		int k = 3;
		List<Integer> ans = firstNegativeSubArrayOfK(arr, k);
		for(Integer item : ans) {
			System.out.println(item);
		}

	}
	
	
public static List<Integer> firstNegativeSubArrayOfK(int arr[], int k) {
	
		Queue<Integer> q = new LinkedList<>();
		List<Integer> ans = new ArrayList<>();
		
		int n = arr.length;
		int i=0, j=0;
		
		while(j< n) {
			
			if(arr[j] < 0) q.add(j);
			
			if(j-i+1 < k) {
				j++;
			}else if(j-i+1 == k) {
				if(q.size() > 0) {
					ans.add(arr[q.peek()]);
					if(i == q.peek()) {
						q.poll();
					}
				}else {
					ans.add(0);
				}
				i++;
				j++;
			}
			
			
		}	
		return ans;
	}

}
