package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {

    public static void main(String[] args) {

    }

}

class MedianFinder {
//    Comparator<Integer> comparator = new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return -(o1-o2);
//        }
//    };
    Comparator<Integer> comparator = (a, b) -> -(a - b);

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue(comparator);
        minHeap = new PriorityQueue();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size() - minHeap.size() > 1 ) minHeap.add(maxHeap.poll());
        if(minHeap.size() != 0 && maxHeap.size() != 0 && maxHeap.peek() > minHeap.peek()) minHeap.add(maxHeap.poll());
        if(minHeap.size() - maxHeap.size() > 1 ) maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        if(size1 == size2 ) {
            return (minHeap.peek() + maxHeap.peek()) / (double)2;
        }else if (size1 > size2) {
            return maxHeap.peek();
        }else{
            return minHeap.peek();
        }
    }
}
