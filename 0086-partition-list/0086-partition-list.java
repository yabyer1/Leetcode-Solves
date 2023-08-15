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
        ListNode nH = new ListNode(0);
        ListNode sH = new ListNode(0);;
        ListNode runner1 = nH;
        ListNode runner2 = sH;
        while(head != null){
            if(head.val < x){
                runner1.next = new ListNode(head.val);
                runner1 = runner1.next;
            }
            else{
                runner2.next = new ListNode(head.val);
                runner2 = runner2.next;
            }
            head = head.next;
        }
    
    runner1.next = sH.next;
    return nH.next;
    }
}