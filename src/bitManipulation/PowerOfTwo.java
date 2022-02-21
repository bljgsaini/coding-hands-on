package bitManipulation;

//231. Power of Two
public class PowerOfTwo {

    public static void main(String[] args) {

    }

    // power of two will always contain only one bit
    // 2^0 => 00000001
    //2^1 =>  00000010
    //2^2 => 00000100 like this.
    // one possible solution can be if we can just count number of set(1) bits in number and count is one then we can say it's power of one.
    // we can another approach also we can unset(0) the set bit and check if number becomes zero or not.
    // since there is only one set bit, number will become zero.

    public boolean isPowerOfTwo(int n) {
        // edge condition power of two will always be greater than zero
        // for example 2^0=1, 2^1 = 2, 2^2 = 4 ...
        if( n <= 0 ) return false;

        return (n & n-1) == 0;

        // eg1    n = 8 => 1000
        //and (n-1) = 7 => 0111 and doing the bitwise '&' of (n & n-1) will be 0000

        // eg2   n=10 => 1010
        //and   (n-1) => 1001 and doing the bitwise '&' of (n & n-1) will be 1000
    }
}
