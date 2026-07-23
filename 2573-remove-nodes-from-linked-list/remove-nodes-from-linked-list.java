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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;

        if(head == null || head.next == null)
            return head;
        
        st.push(temp.val);
        temp = temp.next;

        while(temp != null){
            if(st.size() != 0 && temp.val > st.peek()){
                while(!st.isEmpty() && st.peek() < temp.val){
                    st.pop();
                }
            st.push(temp.val);
            }
            else{
                st.push(temp.val);
            }
            temp = temp.next;
        }

        ListNode prev = null;
        while(!st.isEmpty()){
            ListNode node = new ListNode();
            node.val = st.pop();
            node.next = prev;
            prev = node;
        }

        return prev;
    }
}