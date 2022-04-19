package minStackLeetcode155;

//https://leetcode.com/problems/min-stack/
public class Solution {
}


class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

class MinStack {

    Node minStack;
    Node stack;

    public MinStack() {
        minStack = null;
        stack = null;
    }

    public void push(int val) {
        Node node = new Node(val);
        if(stack == null) {
            stack = node;
            minStack = node;
            return;
        }

        node.next = stack;
        stack = node;

        if(minStack.val >= node.val){
            node = new Node(val);
            node.next = minStack;
            minStack = node;
        }

    }

    public void pop() {
        if(stack == null ) return;
        Node node = stack;
        stack = stack.next;

        if(node.val <= minStack.val){
            minStack = minStack.next;
        }

    }

    public int top() {
        if(stack == null ) return -1;
        return stack.val;
    }

    public int getMin() {
        if(minStack == null) return -1;
        return minStack.val;
    }
}
