package maxAttendetEventsLeetcode1353;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

//1353. Maximum Number of Events That Can Be Attended
public class Solutions {

    public static void main(String[] args) {

    }

    public int maxEventsOptimizedUsingPriorityQueue(int[][] events) {

        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);

        Arrays.sort(events, comparator);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int count = 0;
        int day = 0;

        while(i < events.length || !pq.isEmpty()){

            if(pq.isEmpty()) day = events[i][0];

            // add all the concurrent event to the queue
            while( i< events.length &&  day == events[i][0]){
                pq.add(events[i][1]);
                i++;
            }

            // process the event which is ending early
            pq.poll();
            count++; // one possible result

            //remove events which been ended till current day
            while( !pq.isEmpty() && day >= pq.peek()){
                pq.poll();
            }

            //go to next day
            day++;

        }

        return count;
    }

    public int maxEvents(int[][] events) {

        Comparator<int[]> comparator = (a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        };

        Arrays.sort(events, comparator);

        TreeSet<Integer> set = new TreeSet();
        for(int i=1; i<=100000; i++){
            set.add(i);
        }
        int count = 0;
        for(int [] event : events){
            Integer nextAvailableDay = set.ceiling(event[0]);
            if(nextAvailableDay != null && nextAvailableDay <= event[1]) {
                count++;
                set.remove(nextAvailableDay);
            }
        }

        return count;
    }

}
