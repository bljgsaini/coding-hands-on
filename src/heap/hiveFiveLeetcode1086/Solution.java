package hiveFiveLeetcode1086;


import java.util.PriorityQueue;
import java.util.TreeMap;

//https://leetcode.com/problems/high-five/
// Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student’s top five average.
// Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.
// A student’s top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
// Example 1:
// Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
// Output: [[1,87],[2,88]]
// Explanation:
// The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
// The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
// Example 2:
// Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
// Output: [[1,100],[7,100]]
// Constraints:
// 1 <= items.length <= 1000
// items[i].length == 2
// 1 <= IDi <= 1000
// 0 <= scorei <= 100
// For each IDi, there will be at least five scores.
public class Solution {


    public static void main(String[] args) {
        int [][] items = {{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100}};
        int [][] items2 = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int ans[][] = hiveFive(items2);

        for(int []student: ans){
            System.out.println("id="+ student[0]+ " score="+ student[1]);
        }

    }

    public static int[][] hiveFive(int[][] items){

        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for( int [] item : items){
            int id = item[0];
            int score = item[1];
            PriorityQueue<Integer> heap;
            if(map.containsKey(id)){
                heap = map.get(id);
                if(heap.size() >= 5 && heap.peek() < score) {
                    heap.poll();
                    heap.add(score);
                }else if(heap.size() < 5){
                    heap.add(score);
                }
            }else{
                heap = new PriorityQueue<>();
                heap.add(score);
            }
            map.put(id, heap);
        }

        int[][] ans = new int[map.size()][2];
        int i= 0;
        for(int key: map.keySet()){
            int sum = 0;
            PriorityQueue<Integer> heap = map.get(key);
            while(!heap.isEmpty()){
                sum+= heap.poll();
            }
            ans[i][0] = key;
            ans[i][1] = sum/5;
            i++;
        }
        return ans;
    }

}
