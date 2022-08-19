package array.pascalsTriangleIILeetcode119;

//119. Pascal's Triangle II
//https://leetcode.com/problems/pascals-triangle-ii/

/*Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]

Constraints: 0 <= rowIndex <= 33
Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space? */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = null;
        for(int i=0; i<= rowIndex; i++){
            List<Integer> list =new ArrayList(i+1);
            list.add(0, 1);
            for(int j=1; j<i; j++ ){
                list.add(j, prev.get(j-1) + prev.get(j));
            }
            if(i > 0){
                list.add(i, 1);
            }
            prev = list;
        }
        return prev;
    }

}
