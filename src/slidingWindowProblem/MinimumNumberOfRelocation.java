package slidingWindowProblem;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRelocation {
    public static void main(String[] args) {
        int num1[] = {10, -10, -1, -1, 10};
        int num2[] = {-1, -1, -1, 1, 1, 1, 1};
        int num3[] = {5, -2, -3, 1};
        int num4[] = {-5, -2, -3,-5, -6, 30, 5, 6, 10, -50, -100, 500};

        System.out.println(new MinimumNumberOfRelocation().solution(num1));
        System.out.println(new MinimumNumberOfRelocation().solution(num2));
        System.out.println(new MinimumNumberOfRelocation().solution(num3));
        System.out.println(new MinimumNumberOfRelocation().solution(num4));
    }

    public int solution(int []A){
        int count = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] < 0) pq.add(A[i]);
            sum += A[i];
            if(sum < 0 ){
                count++;
                int num = pq.remove();
                sum += Math.abs(num);
            }
        }
        return count;
    }

}
