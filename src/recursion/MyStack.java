package recursion;

import java.util.Stack;

public class MyStack {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		
		reverseStack(s);
		
		while(s.size() > 0) {
			System.out.println(" " + s.peek());
			s.pop();
		}

	}
	
	
	public static void reverseStack(Stack<Integer>s ) {
		if(s.size() == 0 ) return ;
		
		int temp = s.pop();
		System.out.println("temp = " + temp);
		
		reverseStack(s);

		insertAtStart(s, temp);

	}
	
	public static void insertAtStart(Stack<Integer> s, int ele) {
				
		if(s.size() == 0 ) {
			s.push(ele);
			return;
		}
		
		int temp = s.pop();
		insertAtStart(s, ele);
		s.push(temp);
		
	}
	
	
	public static void deleteMiddle(Stack<Integer> s, int k) {
		if(s.size() == 0 ) return ;
		if(k == 1 ) {
			s.pop();
			return;
		}
		
		int temp = s.pop();
		deleteMiddle(s, k-1);
		s.push(temp);
		
	}
	
	
	public static void sort(Stack<Integer> s) {
		//base condition
		if(s.size() == 1) return;
		
		int temp = s.pop();
		//hypothesis
		sort(s);
		//induction
		insert(s, temp);
	
	}
	
	
	public static void insert(Stack<Integer> s, int temp) {
		//base condition
		if(s.size() == 0 || s.peek() < temp) {
			s.push(temp);
			return ;
		}
		
		int temp1 = s.pop();
		//hypothesis
		insert(s, temp);
		//Induction
		s.push(temp1);
		
	}
	

}
