package heap.taskSchedulerLeetcode621;


import java.util.*;

//https://leetcode.com/problems/task-scheduler/
public class Solution {
    public static void main(String[] args) {

    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        for(char ch : tasks){
            map.put( ch, map.getOrDefault(ch, 0)+1 );
        }

        Comparator<Integer> comparator = (a,b)-> -(a-b);
        PriorityQueue<Integer> pq = new PriorityQueue(comparator);
        for(char ch : map.keySet()){
            pq.add(map.get(ch));
        }

        Queue<Pair>queue = new LinkedList();
        int t = 0;

        // loop until heap and queue are not empty
        while(pq.size() > 0 || queue.size() > 0){
            t++;
            // if heap is not empty then poll the task and execute and push the remaining the task to queue with next available timestamp
            if(pq.size() > 0){
                int num = pq.poll();
                if(num > 1) queue.add(new Pair(num-1, t+n));
            }

            // if queue is not empty and any task is available to be picked up by CPU => add that to heap
            if(queue.size() > 0 && queue.peek().time == t){
                pq.add(queue.poll().freq);
            }
        }
        return t;
    }

}


class Pair{
    int freq;
    int time;
    public Pair(int freq, int time){
        this.freq = freq;
        this.time = time;
    }
}
