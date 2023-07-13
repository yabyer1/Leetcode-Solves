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
    public int pairSum(ListNode head) {
        ArrayList<Integer> NodeSUm = new ArrayList<>();
        while(head != null){
            NodeSUm.add(head.val);
            head = head.next;
        }
        int ans = 0;
        int i = 0;
        int j = NodeSUm.size() - 1;
        while(i < j){
            ans = Math.max(ans, NodeSUm.get(i) + NodeSUm.get(j));
            i++;
            j--;
        }
        return ans;
    }
}