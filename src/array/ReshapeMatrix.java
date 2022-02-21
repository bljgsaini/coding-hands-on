package array;

//566. Reshape the Matrix
public class ReshapeMatrix {
    public static void main(String[] args) {

    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if(m*n != r*c || (m == r && n == c)) return mat;

        int a = 0, b = 0;
        int ans[][] = new int[r][c];
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){

                ans[a][b] = mat[i][j];

                if(b == c-1){
                    a += 1;
                    b = 0;
                }else{
                    b+=1;
                }

            }
        }
        return ans;
    }

}
