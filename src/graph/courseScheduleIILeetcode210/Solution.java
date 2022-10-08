package graph.courseScheduleIILeetcode210;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/course-schedule-ii/
public class Solution {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap();
        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList());
        }
        for(int [] edge: prerequisites){
            List<Integer> temp = adjList.get(edge[0]);
            temp.add(edge[1]);
            adjList.put(edge[0], temp);
        }
        int[] visited = new int[numCourses];
        List<Integer> tempAns = new ArrayList();
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0 ) {
                if(!dfs(i, adjList, visited, tempAns)) return new int[0];
            }
        }

        int []ans = new int[tempAns.size()];
        int i = 0;
        for(int num: tempAns){
            ans[i] = num;
            i++;
        }

        return ans;
    }

    public boolean dfs(int start, Map<Integer, List<Integer>> adjList, int[] visited, List<Integer> tempAns){
        if(visited[start] == 2 ) return true;
        visited[start] = 1;
        List<Integer> dependents = adjList.get(start);
        for(int course: dependents){
            if(visited[course] == 0 || visited[course] == 2){
                if(!dfs(course, adjList, visited, tempAns)) return false;
            }else{
                return false;
            }
        }
        tempAns.add(start);
        visited[start] = 2;
        return true;
    }

}
