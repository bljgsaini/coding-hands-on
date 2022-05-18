package mathematics.numberGPSubSequencesSize3;

import java.util.HashMap;
import java.util.Map;


//https://www.geeksforgeeks.org/number-gp-geometric-progression-subsequences-size-3/
public class Solution {
    public static void main (String[] args) {
        int arr[] = {1, 1, 2, 2, 4}; int r = 3;
        System.out.println(numberOfGP(arr, r));
    }

    public static int numberOfGP(int arr[], int r){
        Map<Integer, Integer> mapLeft = new HashMap();
        Map<Integer, Integer> mapRight = new HashMap();

        for(int i=0; i<arr.length; i++){
            mapRight.put(arr[i], mapRight.getOrDefault(arr[i], 0) + 1 );
        }

        int ans = 0;
        for(int i=0; i<arr.length; i++){
            int freqNum = mapRight.get(arr[i]);
            if(freqNum == 1 ) mapRight.remove(arr[i]);
            else mapRight.put(arr[i], freqNum-1);

            int leftCount = mapLeft.getOrDefault(arr[i]/r, 0);
            int rightCount = mapRight.getOrDefault(arr[i]*r, 0);
            ans += leftCount*rightCount;

            mapLeft.put(arr[i], mapLeft.getOrDefault(arr[i], 0) + 1);

        }
        return ans;
    }
}
