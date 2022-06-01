package sorting.hIndexLeetcode274;

public class Solution {
    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int freq[] = new int[n+1];
        for(int num: citations){
            if(num >= n ){
                freq[n]++;
            }else{
                freq[num]++;
            }
        }
        int h = 0;
        for(int citation=n; citation>0; citation--){
            h+= freq[citation];
            if( h >= citation ) return citation;
        }
        return 0;
    }

    /*
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int num: citations){
            heap.offer(num);
        }
        while(!heap.isEmpty()){
            if(heap.peek() >= heap.size()) return heap.size();
            heap.poll();
        }
        return 0;
    }
    */

}
