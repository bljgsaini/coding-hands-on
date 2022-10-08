package graph.courseScheduleLeetcode207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://leetcode.com/problems/course-schedule/
public class Solution {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap();
        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList());
        }

        for(int [] edge: prerequisites){
            List<Integer> temp = adjList.get(edge[0]);
            temp.add(edge[1]);
            adjList.put(edge[0], temp);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] processed = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i]) {
                if(!dfs(i, adjList, visited, processed)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int start, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] processed){
        if(processed[start]) return true;
        visited[start] = true;
        List<Integer> dependents = adjList.get(start);
        for(int course: dependents){
            if(!visited[course] || processed[course]){
                if(!dfs(course, adjList, visited, processed)) return false;
            }else{
                return false;
            }
        }
        processed[start] = true;
        return true;
    }

    public boolean canFinishUpdated(int numCourses, int[][] prerequisites) {
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
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0 ) {
                if(!dfs(i, adjList, visited)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int start, Map<Integer, List<Integer>> adjList, int[] visited){
        if(visited[start] == 2 ) return true;
        visited[start] = 1;
        List<Integer> dependents = adjList.get(start);
        for(int course: dependents){
            if(visited[course] == 0 || visited[course] == 2){
                if(!dfs(course, adjList, visited)) return false;
            }else{
                return false;
            }
        }
        visited[start] = 2;
        return true;
    }

}
