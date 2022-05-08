package array.mergeIntervalsLeetcode56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


//https://leetcode.com/problems/merge-intervals/
public class Solution {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {

        Comparator<int []> comparator = (a, b)-> a[0] - b[0];
        Arrays.sort(intervals, comparator);
        List<Node> list = new LinkedList();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] > end ){
                list.add(new Node(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }else if(intervals[i][0] <= end ){
                end = Math.max(end, intervals[i][1]);
            }
        }

        list.add(new Node(start, end));
        int n = list.size();
        int ans[][] = new int[n][2];
        int i= 0;
        for( Node node : list){
            ans[i][0] = node.start;
            ans[i][1] = node.end;
            i++;
        }
        return ans;
    }


}

class Node{
    int start;
    int end;
    public Node(int start, int end){
        this.start = start;
        this.end = end;
    }
}
