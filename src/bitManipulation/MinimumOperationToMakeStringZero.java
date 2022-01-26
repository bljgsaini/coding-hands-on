package bitManipulation;

public class MinimumOperationToMakeStringZero {
    public static void main(String[] args) {
        System.out.println(new MinimumOperationToMakeStringZero().solution("01110"));
    }

    public int solution(String s){
        String newString = s.substring(s.indexOf('1'));
        int one = 0;
        int zero = 0;
        for(int i=0; i<newString.length(); i++){
            if(newString.charAt(i) == '1') one+=1;
            else zero+=1;
        }
        return zero + one*2 -1;
    }

}
