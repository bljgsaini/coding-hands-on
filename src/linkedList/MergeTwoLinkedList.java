package linkedList;

import java.util.List;

public class MergeTwoLinkedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode merged = mergeTwoLists(list1, list2);

        printList(merged);


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null ) return list2;
        if(list2 == null ) return list1;

        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode root = null;
        while(null != l1 || null != l2){
            ListNode temp = null;
            if(l1 != null && l2 != null ){
                int num1 = l1.val;
                int num2 = l2.val;

                if(num1 <= num2){
                    temp = new ListNode(num1);
                    l1 = l1.next;
                }else{
                    temp = new ListNode(num2);
                    l2 = l2.next;
                }
            }else if(l1 != null){
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }else if(l2 != null){
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }

            if(root == null){
                root = temp;
            }else{
                ListNode head = root;
                while(head.next != null){
                    head = head.next;
                }
                head.next = temp;
            }


        }
        return root;
    }

    public static void printList(ListNode head){
        if(head == null ) return ;
        System.out.print(head.val + " ");
        printList(head.next);
    }

}
