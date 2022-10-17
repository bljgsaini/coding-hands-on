package assessmentProblems.healthP;

import java.util.HashSet;
import java.util.Set;


// "static void main" must be defined in a public class.

//Given two variables, x, and y, swap two variables without using a third variable.

/*
x = 5
y = 6

x = x^y
y = (x^y)^y=> x

x = x^y^x => y
*/
/*
Write a removeDuplicates() function that takes a list and deletes any duplicate nodes from the list. The list is not sorted.

=> 1 3 1 5 6 5 => 1 3 5 6
=> 1, 3,

=> any integer
*/
/*
An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time. find a element

3 4 5 1 2
4 5 1 2 3
5 1 2 3 4
1 2 3 4 5
2 3 4 5 1

n => n/2 => n/4

1 2 3 4 5 6 7 8 9 10 11
3 4 5 6 7 8 9 10 11 1 2
BinarySearch(low, high, arr);
mid =
*/
/*
Given a binary string S, the task is to find the longest subsequence with that has equal number of 0s and 1s and all the 0s are present before all the 1s.
0011001111=>00001111

1111100000
10101010=> 0011
zeroCount = 4
oneCount = 0

01010101
zeroCount = 2
oneCount = 0
=> 01, 0011
0000011111111000=>
000111

01010101

0s= 3
1s = 1

2
4
4

*/

public class Solution {
    public static void main(String[] args) {
        /* Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(5);

        head = removeDepulicates(head);

        while(head!= null){
            System.out.print(head.val + " ");
            head = head.next;
        }*/
        /* int arr[] = {3,4,5,6,7,8,9,10,11,1,2};
        System.out.println("index=> "+binarySearchRotated(0, arr.length-1, arr, 2));*/

        String s = "11001"; //abcdefg=> adg
        int ans = binaryLongestSubsequence(s);
        System.out.println("ans=>" + ans);

    }

    public static int binaryLongestSubsequence(String s){
        int countZeros = 0;
        int countOnes = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') countOnes++;
        }

        int ans = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                countZeros++;
            }else{
                countOnes--;
            }
            //System.out.println("countZeros=>" + countZeros);
            //System.out.println("countOnes=>" + countOnes);
            ans = Math.max(ans, 2*Math.min(countZeros, countOnes));
        }
        return ans;
    }

    public static int binarySearchRotated(int low, int high, int arr[], int k){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == k) return mid;
            if(arr[low] <= arr[mid]){
                if(k >= arr[low] && k < arr[mid]){
                    return binarySearch(low, mid-1, arr, k);
                }else{
                    low = mid+1;
                }
            }else{
                if(k > arr[mid] && k <= arr[high]){
                    return binarySearch(mid+1, high, arr, k);
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int low, int high, int arr[], int k){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == k ) return mid;
            else if(arr[mid] > k ){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static Node removeDepulicates(Node head){
        if(head == null ) return head;
        Set<Integer> set = new HashSet();
        Node prev = null;
        Node temp = head;
        while(temp!= null){
            if(set.contains(temp.val)){
                prev.next = temp.next;
            }else{
                set.add(temp.val);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void solveSwapElement(){
        int x =5;
        int y = 6;
        x = x^y;
        y = x^y;
        x = x^y;
        System.out.println("x = > " + x + " y=> " + y);
    }
}

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        next = null;
    }
}
