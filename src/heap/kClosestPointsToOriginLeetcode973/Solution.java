package heap.kClosestPointsToOriginLeetcode973;

import java.util.Comparator;
import java.util.PriorityQueue;


//https://leetcode.com/problems/k-closest-points-to-origin/submissions/
public class Solution {
    public static void main(String[] args) {

    }

    PriorityQueue<Pair> pq;

    public int[][] kClosest(int[][] points, int k) {
        Comparator<Pair> comparator = (a, b) -> Integer.compare( b.x*b.x + b.y*b.y, a.x*a.x + a.y*a.y) ;
        pq = new PriorityQueue(comparator);
        for(int[] point : points){
            if(pq.size() < k){
                pq.add(new Pair(point[0], point[1]));
                continue;
            }
            Pair pair = pq.peek();
            if( ( pair.x * pair.x + pair.y*pair.y) > ( point[0]*point[0] + point[1]*point[1]) ){
                pq.poll();
                pq.add(new Pair(point[0], point[1]));
            }
        }
        int size = pq.size();
        int[][] ans = new int[size][2];
        int index = 0;
        while(pq.size() != 0){
            Pair pair = pq.poll();
            ans[index][0] = pair.x;
            ans[index][1] = pair.y;
            index++;
        }
        return ans;
    }

}

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
