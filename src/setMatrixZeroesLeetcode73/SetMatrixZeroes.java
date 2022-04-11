package setMatrixZeroesLeetcode73;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int rowFlag = 0, colFlag = 0;
        for(int i=0; i<m; i++) if(matrix[i][0] == 0) rowFlag = -1;
        for(int j=0; j<n; j++) if(matrix[0][j] == 0) colFlag = -1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)  matrix[i][j] = 0;
            }
        }

        if(rowFlag == -1) for(int i=0; i<m; i++) matrix[i][0] = 0;
        if(colFlag == -1) for(int j=0; j<n; j++) matrix[0][j] = 0;

    }

}
