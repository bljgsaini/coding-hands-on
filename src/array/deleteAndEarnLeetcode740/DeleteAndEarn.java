package deleteAndEarnLeetcode740;

//https://leetcode.com/problems/delete-and-earn/
public class DeleteAndEarn {


    /*Input: nums = [2,2,3,3,3,4]
    Output: 9

    Input: nums = [3,4,2]
    Output: 6*/

    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        int maxArr[] = new int[max+1];
        for(int num: nums){
            maxArr[num] += num;
        }

        int earnedPoint1 = 0;
        int earnedPoint2 = 0;
        for(int i=1; i<= max; i++){
            int temp = Math.max(maxArr[i] + earnedPoint2, earnedPoint1);
            earnedPoint2 = earnedPoint1;
            earnedPoint1 = temp;
        }

        return earnedPoint1;

    }

}
