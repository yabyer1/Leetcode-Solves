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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode arr[] = new ListNode[k];
        int space[] = new int[k];
        ListNode runner  = head;
        int count = 0;
        while(runner != null){
            count++;
            runner = runner.next;
        }
        int NumPer = count / k;
        int remainder = count % k;
        for(int i = 0; i < space.length; i++){
            if(remainder > 0){
            space[i] = NumPer + 1;
            remainder--;
            }
            else{
                space[i] = NumPer;
            }
            
        }
        int cur = 0; 
        ListNode prev  = new ListNode(90);
        runner = head;
        prev.next = head;
        for(int i = 0; i < arr.length; i++){
            if(cur == count){
                break;
            }
            ListNode tempHead  = new ListNode();
            tempHead.next = runner;
            for(int j = 0; j < space[i]; j++){
                if(cur == count){
                    break;
                }
                if(runner == null){
                    break;
                }
                runner = runner.next;
                prev = prev.next;
                cur++;
            }
            prev.next = null;
            prev  = new ListNode(90);
           prev.next = runner;
         
            arr[i] = tempHead.next;

        }
        return arr;
    }
}