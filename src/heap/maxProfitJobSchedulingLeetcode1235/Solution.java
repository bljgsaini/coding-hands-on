package heap.maxProfitJobSchedulingLeetcode1235;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i=0; i<startTime.length; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Comparator<Job> comparator = (a, b)-> a.start - b.start;
        Arrays.sort(jobs, comparator);
        int []dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        return recSol(jobs, 0, dp);
    }

    public int recSol(Job[] jobs, int start, int []dp){
        if(start >= jobs.length) return 0;
        if(dp[start] != -1) return dp[start];
        int i = start+1;
        while(i < jobs.length && jobs[i].start < jobs[start].end ) i++;
        dp[start] = Math.max( jobs[start].profit + recSol(jobs, i, dp), recSol(jobs, start+1, dp));
        return dp[start];
    }
}

class Job{
    int start;
    int end;
    int profit;
    public Job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
