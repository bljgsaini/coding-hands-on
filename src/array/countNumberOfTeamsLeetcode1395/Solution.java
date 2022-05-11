package array.countNumberOfTeamsLeetcode1395;

//https://leetcode.com/problems/count-number-of-teams/
public class Solution {
    public static void main(String[] args) {

    }


    public int numTeams(int[] rating) {
        int count = 0;
        for(int i=0; i<rating.length; i++){
            int leftSmaller = 0;
            int leftGreater = 0;
            for(int j=0; j<i; j++) {
                if (rating[j] < rating[i]) leftSmaller++;
                if (rating[j] > rating[i]) leftGreater++;
            }
            int rightSmaller = 0;
            int rightGreater = 0;
            for(int j=i+1; j<rating.length; j++){
                if(rating[i] < rating[j]) rightGreater++;
                if(rating[i] > rating[j]) rightSmaller++;
            }
            count+= leftSmaller * rightGreater + leftGreater*rightSmaller;
        }
        return count;
    }

}
