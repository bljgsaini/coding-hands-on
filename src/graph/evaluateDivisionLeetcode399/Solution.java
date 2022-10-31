package graph.evaluateDivisionLeetcode399;

import java.util.*;

//https://leetcode.com/problems/evaluate-division/
public class Solution {
    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> map = new HashMap();
        buildMap(equations, values, map);

        double[] ans = new double[queries.size()];
        int k =0;
        for(List<String> list: queries){
            Set<String> visited = new HashSet();
            double tempAns = solve(map, list.get(0), list.get(1), visited, 1.0);
            ans[k++] = tempAns;
        }
        return ans;
    }

    public double solve(Map<String, List<Pair>> map, String start, String end, Set<String> visited, double value){
        if(!map.containsKey(start) || visited.contains(start)) return -1;
        if(start.equals(end)) return value;

        visited.add(start);
        List<Pair> children = map.get(start);
        for(Pair pair: children){
            double temp = solve(map, pair.key, end, visited, value*pair.value);
            if(temp != -1) return temp;
        }
        visited.remove(start);
        return -1;
    }

    public void buildMap(List<List<String>> equations, double[] values, Map<String, List<Pair>> map){
        int k=0;
        for(List<String> list: equations){
            List<Pair> children = map.getOrDefault(list.get(0), new ArrayList());
            children.add(new Pair(list.get(1), values[k]));
            map.put(list.get(0), children);

            children = map.getOrDefault(list.get(1), new ArrayList());
            children.add(new Pair(list.get(0), 1/values[k]));
            map.put(list.get(1), children);
            k++;
        }
    }

}


class Pair{
    String key;
    double value;
    public Pair(String key, double value){
        this.key= key;
        this.value = value;
    }
}