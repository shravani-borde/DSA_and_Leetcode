/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int size(ListNode head){
        int n = 0;
        ListNode temp = head;
        while(temp != null)
        {
            n++;
            temp = temp.next;
        }
        return n;
    }

    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null)
            return head;

        int n = size(head);
        k = k%n;

        if(k == 0)
            return head;
        
        ListNode slow = head, fast = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }
}