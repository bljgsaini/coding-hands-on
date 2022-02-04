package linkedList;

public class LinkedCycle {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = list1;

        if(hasCycle(list1)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while(fast != null && fast.next!=null ){
            head = head.next;
            fast = fast.next.next;
            if(head == fast) return true;
        }
        return false;
    }

}
