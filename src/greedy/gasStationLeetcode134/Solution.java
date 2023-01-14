package gasStationLeetcode134;


//134. Gas Station
public class Solution {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sumGas = 0;
        int sumCost = 0;

        int index = 0;
        int rem = 0;

        for(int i=0; i<gas.length; i++){
            sumGas+= gas[i];
            sumCost += cost[i];

            rem+= gas[i];
            rem -= cost[i];

            if(rem < 0){
                rem = 0;
                index = i+1;
            }

        }

        if(sumGas < sumCost ) return -1;

        return index;
    }


    public int canCompleteCircuitBruteForceApproach(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++){
            boolean flag = canCompleteCircuitUtil(i, gas, cost);
            if(flag) return i;
        }
        return -1;
    }

    public boolean canCompleteCircuitUtil(int start, int gas[], int cost[]){
        int n = gas.length;
        int count = 0;
        int rem = 0;
        while(count < n){
            start %=n;
            rem += gas[start];
            rem -= cost[start];
            if(rem < 0) return false;
            count++;
            start++;
        }
        return true;

    }

}
