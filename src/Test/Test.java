package Test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static int ans;

    public static void main(String[] args) {
        ans = -1;
        int sum = 15;
        int digit = 3;
        solve(sum, digit, new ArrayList<>());
        System.out.println("ans=>" + ans);
    }


    public static void solve(int sum, int digit, List<String> list){
        if(sum >= 0 && sum <= 9 && digit == 0){
            int num = 0;
            for(String str: list){
                int temp = Integer.parseInt(str);
                num = num*10 + temp;
            }
            if(num > ans){
                ans = num;
            }
            return;
        }
        if(digit == 0) return;

        for(int i=1; i<=9; i++){
            list.add(String.valueOf(i));
            solve(sum-i, digit-1, list);
            list.remove(list.size()-1);
        }

    }


}
