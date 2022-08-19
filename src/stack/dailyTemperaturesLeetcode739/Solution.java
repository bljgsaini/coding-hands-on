package stack.dailyTemperaturesLeetcode739;


import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/daily-temperatures/
/* Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]*/
public class Solution {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque();
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i] ){
                deque.pop();
            }
            if(deque.isEmpty()) ans[i] = 0;
            else ans[i] = deque.peek() - i;
            deque.push(i);
        }
        return ans;
    }


}
