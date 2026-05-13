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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode larger = new ListNode(0);
        ListNode temp1 = smaller;
        ListNode temp2 = larger;

        while(head != null)
        {
            if(head.val < x)
            {
                temp1.next = head;
                temp1 = temp1.next;
            }
            else
            {
                temp2.next = head;
                temp2 = temp2.next;
            }

            head = head.next;
        }
        temp1.next = larger.next;
        temp2.next = null;

        return smaller.next;
    }
}