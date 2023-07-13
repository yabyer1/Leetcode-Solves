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
    public ListNode swapNodes(ListNode head, int k) {
        
        int length = 0;
        ListNode runner = head;
        while(runner != null){
            length++;
            runner = runner.next;
        }
        int StartNode = k;
        int EndNode = length - k + 1;
       
        if(StartNode == EndNode){
            return head;
        }
        // runner = head;
        ListNode temp = head;
        for(int i = 1; i < StartNode; i++){
           
               // runner = runner.next;
                temp = temp.next;
        }
       // ListNode runner2 = head;
        ListNode temp2 = head;
         //System.out.println(runner.val +" " + temp.val);
          for(int i = 1; i < EndNode; i++){
            
               // runner2 = runner2.next;
                temp2 = temp2.next;
        }
       // System.out.println(runner2.val +" " + temp2.val);
        // Swap(runner, temp, runner2, temp2);
        int temp3 = temp2.val;
        temp2.val = temp.val;
        temp.val = temp3;
         return head;
    }
    /*
    void Swap(ListNode runner, ListNode temp, ListNode runner2, ListNode temp2){
        ListNode finTemp = temp2.next;
        temp2.next = temp.next;
        runner.next = temp2;
        temp.next = finTemp;
        runner2.next = temp;
    }
    */
}