import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {


    // matrix : 2*n maximum sum
   /* 1 2 3 4 5
    6 7 8 9 10 => 6, 7, 8, 9, 10 => 6 + 8 + 10

    Max(arr[i] + solve(i+2, arr), solve(i+1, arr))*/

    public static void main(String[] args) {

        int [][]arr = {{0,-2,-3,-4,-5}, {-6,-7,-8,-9,-10}};
        System.out.println("result=> " + solve(0, arr, arr[0].length));

    }


    static Map<Integer, Integer> map = new HashMap<>();

    public static int solve(int start, int[][]arr, int n){
        if(start == n-1 ) return Math.max(arr[0][start], arr[1][start]);
        if(start == n-2 ) return Math.max( Math.max(arr[0][start], arr[1][start]), Math.max(arr[0][start+1], arr[1][start+1]));

        if(map.containsKey(start)) map.get(start);
        map.put(start, Math.max( Math.max(arr[0][start], arr[1][start]), Math.max( Math.max(arr[0][start], arr[1][start]) + solve(start+2, arr, n), solve(start+1, arr, n)) ));
        return map.get(start);
    }

}
