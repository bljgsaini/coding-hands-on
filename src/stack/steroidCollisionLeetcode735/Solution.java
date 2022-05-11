package stack.steroidCollisionLeetcode735;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/asteroid-collision/
public class Solution {

    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque();

        for (int asteroid : asteroids) {
            if (asteroid > 0) stack.push(asteroid);
            else if (asteroid < 0) {
                while (isCollisionWithSmallerAsteroid(stack, asteroid)) stack.pop();
                if (stack.isEmpty() || stack.peek() < 0) stack.push(asteroid);
                else if (stack.peek() == Math.abs(asteroid)) stack.pop();
            }
        }

        int[] ans = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ans[i] = stack.removeLast();
            i++;
        }
        return ans;
    }

    private boolean isCollisionWithSmallerAsteroid(Deque<Integer> stack, int asteroid) {
        return !stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid);
    }

}
