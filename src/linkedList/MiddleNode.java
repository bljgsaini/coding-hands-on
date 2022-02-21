package linkedList;

//876. Middle of the Linked List
public class MiddleNode {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        return middleNodeSolution1(head);
    }

    public ListNode middleNodeSolution1(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNodeSolution2(ListNode head) {
        int n = countList(head);
        for(int i=0; i<n/2; i++){
            head = head.next;
        }
        return head;
    }

    public int countList(ListNode head){
        if(head == null ) return 0;
        return 1+countList(head.next);
    }

}
