package recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

	public static void main(String[] args) {
		
		int n = 5;
		int k = 2;
		List<Integer>arr = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			arr.add(i+1);
		}
		
		k--;
		
		solve(arr, 0, k);
		

	}
	
	
	public static void solve(List<Integer> arr, int index, int k) {
		if(arr.size() == 1) {
			System.out.println(arr.get(0));
			return ;
		}
		
		index = (index+k)%arr.size();
		arr.remove(index);
		solve(arr, index, k);
		
	}

}
