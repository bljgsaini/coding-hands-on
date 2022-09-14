package heap.kthLargestElementInStreamLeetcode703;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compareTo;
    }
}


class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue(k);
        for (int num : nums) {
            addValueToQueue(k, num);
        }
    }

    public int add(int val) {
        addValueToQueue(k, val);
        return pq.peek();
    }

    private void addValueToQueue(int k, int num) {
        if(pq.size() < k ) {
            pq.add(num);
            return;
        }
        if (pq.peek() < num) {
            pq.poll();
            pq.add(num);
        }
    }
}
