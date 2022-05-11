package backtracking.nQueensLeetcode51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/n-queens/
public class Solution {

    public static void main(String[] args) {

    }

    Set<Integer> colSet;
    Set<Integer> negDiagonalSet; // for checking is there any queue placed in the right-top diagonal. // since r+c will be unique for each right-top diagonal
    Set<Integer> posDiagonalSet;// for checking is there any queue placed in the right-bottom diagonal. // since r-c will be unique for each right-bottom diagonal

    char [][] matrix;

    public List<List<String>> solveNQueens(int n) {
        colSet = new HashSet();
        negDiagonalSet = new HashSet();
        posDiagonalSet = new HashSet();
        matrix = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = '.';
            }
        }

        List<List<String> > ans = new ArrayList();
        solveNQueensUtil(0, n, ans);

        return ans;

    }


    public void solveNQueensUtil(int r, int n, List<List<String>> ans){
        if(r == n) {
            List<String> temp = new ArrayList();
            for(char [] charArray : matrix){
                temp.add(String.valueOf(charArray));
            }
            ans.add(temp);
            return;
        }

        for(int c = 0; c<n; c++){

            if(colSet.contains(c) || posDiagonalSet.contains(r+c) || negDiagonalSet.contains(r-c) ) continue;

            colSet.add(c);
            posDiagonalSet.add(r+c);
            negDiagonalSet.add(r-c);
            matrix[r][c] = 'Q';

            solveNQueensUtil(r+1, n, ans);

            colSet.remove(c);
            posDiagonalSet.remove(r+c);
            negDiagonalSet.remove(r-c);
            matrix[r][c] = '.';

        }

    }

}
