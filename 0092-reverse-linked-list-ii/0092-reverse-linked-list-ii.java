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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        left--;
        right--;
        int i = 0;
        ListNode runner = head;
        while(i < left){
            i++;
            runner = runner.next;
        }
        ListNode temp = new ListNode(0);
        temp.next = runner;
        Stack<Integer> x = new Stack<>();
        for(int j = i; j <= right; j++){
            x.add(runner.val);
            runner = runner.next;
        }
        runner = temp.next;
        while(!x.isEmpty()){
            runner.val = x.pop();
            runner = runner.next;
        }
        return head;
    }
}