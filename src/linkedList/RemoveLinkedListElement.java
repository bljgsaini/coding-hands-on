package linkedList;

//203. Remove Linked List Elements
public class RemoveLinkedListElement {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {

        if(head == null ) return null;

        if(head.val == val) {
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;

    }

}
