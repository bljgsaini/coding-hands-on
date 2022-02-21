package linkedList;

//19. Remove Nth Node From End of List
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = countElement(head) - n;
        ListNode prev = null;
        ListNode temp = head;
        while(count > 0){
            prev = temp;
            temp = temp.next;
            count--;
        }
        if(temp == head ) return head.next;
        prev.next = temp.next;
        return head;
    }

    public static int countElement(ListNode head){
        if(head == null ) return 0;
        return 1 + countElement(head.next);
    }

}
