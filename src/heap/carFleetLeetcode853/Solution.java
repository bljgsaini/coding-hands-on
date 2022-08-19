package heap.carFleetLeetcode853;


//https://leetcode.com/problems/car-fleet/

/* There are n cars going to the same destination along a one-lane road. The destination is target miles away.

You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).

A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

Return the number of car fleets that will arrive at the destination.



Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Note that no other cars meet these fleets before the destination, so the answer is 3.
Example 2:

Input: target = 10, position = [3], speed = [3]
Output: 1
Explanation: There is only one car, hence there is only one fleet.
Example 3:

Input: target = 100, position = [0,2,4], speed = [4,2,1]
Output: 1
Explanation:
The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The fleet moves at speed 2.
Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.


Constraints:

n == position.length == speed.length
1 <= n <= 105
0 < target <= 106
0 <= position[i] < target
All the values of position are unique.
0 < speed[i] <= 106 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    public int carFleet(int target, int[] positionArray, int[] speedArray) {
        Comparator<Node> comparator = (a, b)-> -(a.position - b.position);
        PriorityQueue<Node> pq = new PriorityQueue<>(comparator);
        for(int i=0; i<positionArray.length; i++){
            pq.add(new Node(positionArray[i], speedArray[i]));
        }

        int fleet = 1;
        int speed = pq.peek().speed;
        double position = pq.peek().position;
        pq.poll();
        while(!pq.isEmpty()){
            Node node = pq.poll();
            double t1 = (target - position)/speed; // time taken by right next car to reach to target
            double t2 = (position - node.position)/(node.speed - speed); // time taken by current car to reach to right next car
            // if current car speed is less or current car takes more time to reach to next car than next car reaches to target
            // then it is new fleet. else it will be combined with next car.
            if(speed > node.speed || t1 < t2 ){
                fleet++;
                speed = node.speed;
                position = node.position;
            }
        }
        return fleet;
    }



    public int carFleetOtherSolution(int target, int[] position, int[] speed){
        // O(n log n) time | O(n) space
        if(position.length == 0)    return 0;
        if(position.length == 1)    return 1;

        // stack stores "time" for each car reaching to destination
        Stack<Double> myStack = new Stack<>();
        int[][] combine = new int[position.length][2];

        // update combine[][]
        for(int i = 0; i < position.length; i++)
        {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, Comparator.comparingInt(a -> a[0]));

        // right -> left because the rightmost car maintains the same speed anyways
        for(int i = position.length-1; i >= 0; i--)
        {
            // it means how much "time" it takes for the car at position i to reach to destination
            double time = (double) (target - combine[i][0]) / combine[i][1];

            // left car spends less time reaching to destination
            // so it will collide the car in front (They become the SAME car fleet)
            // else it will be new fleet.
            if(myStack.isEmpty() && time > myStack.peek())
                myStack.push(time);


        }
        return myStack.size();
    }

}

class Node{
    int position;
    int speed;
    Node(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
}
