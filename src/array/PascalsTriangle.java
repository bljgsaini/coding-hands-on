package array;

import java.util.ArrayList;
import java.util.List;

//118. Pascal's Triangle
public class PascalsTriangle {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            ArrayList<Integer> list = new ArrayList<>(i);
            for(int j=0; j<i; j++){
                list.add(0);
            }
            list.set(0, 1);
            list.set(i-1, 1);
            for(int j=1; j<i-1; j++){
                list.set(j, ans.get(i-2).get(j-1) + ans.get(i-2).get(j) );
            }
            ans.add(list);
        }

        return ans;

    }

}
