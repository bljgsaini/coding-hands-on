package linkedList.reverseNodesInKGroupLeetcode25;

import linkedList.ListNode;


//25. Reverse Nodes in k-Group
//https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode root = null;
        ListNode mainTail = null;

        while(head != null ){
            int i = 0;

            ListNode localHead = head;
            ListNode localPrev = null;
            while(i < k && localHead != null ){
                ListNode temp = localHead.next;
                localHead.next = localPrev;
                localPrev = localHead;
                localHead = temp;
                i++;
            }

            if(i < k){
                localHead = localPrev;
                localPrev = null;
                while(localHead != null ){
                    ListNode temp = localHead.next;
                    localHead.next = localPrev;
                    localPrev = localHead;
                    localHead = temp;
                }
            }

            if(root == null ) root = localPrev;
            else mainTail.next = localPrev;

            mainTail = head;
            head = localHead;

        }

        return root;

    }

}
