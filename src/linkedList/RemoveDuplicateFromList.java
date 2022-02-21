package linkedList;

//83. Remove Duplicates from Sorted List
public class RemoveDuplicateFromList {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ) return null;
        ListNode root = head, prev = head;
        head = head.next;

        while(head!= null){
            if(head.val != prev.val ) {
                prev = head;
                head = head.next;
            }else{
                prev.next = head.next;
                head = head.next;
            }
        }

        return root;

    }

}
