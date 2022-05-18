package designProblems.LRUCacheLeetcode146;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/lru-cache/


public class Solution {


    public static void main(String[] args) {

    }

}

class LRUCache {

    Map<Integer, Node> nodeMap;
    DoublyLinkedList doublyLinkedList;
    int capacity;


    public LRUCache(int capacity) {
        nodeMap = new HashMap();
        doublyLinkedList = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            doublyLinkedList.removeGiven(node);
            doublyLinkedList.addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            doublyLinkedList.removeGiven(node);
            doublyLinkedList.addFirst(node);
        }else{
            if(nodeMap.size() == capacity){
                Node node = doublyLinkedList.getTail();
                doublyLinkedList.removeLast();
                nodeMap.remove(node.key);
            }
            Node node = new Node(key, value);
            doublyLinkedList.addFirst(node);
            nodeMap.put(key, node);
        }
    }


}

class DoublyLinkedList{

    private Node head;
    private Node tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }

    public void addFirst(Node node){
        node.prev = null;
        node.next = null;
        if(head == null ){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void removeLast(){
        if(tail == null ) return;
        if(tail.prev == null ) {
            tail = null;
            head = null;
            return;
        }
        tail.prev.next = null;
        tail = tail.prev;
    }

    public void removeGiven(Node node){
        if(node.prev == null ){
            head = node.next;
            if(node.next == null) tail = null;
            else node.next.prev = null;
        }else{
            node.prev.next = node.next;
            if(node.next == null) tail = node.prev;
            else node.next.prev = node.prev;
        }
    }

}

class Node{
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val =val;
        this.prev = null;
        this.next = null;
    }
}
