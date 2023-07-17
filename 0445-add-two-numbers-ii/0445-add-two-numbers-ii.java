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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        String s = "";
        String f = "";
        while(l1 != null){
            f += l1.val;
            l1 = l1.next;
        }
           while(l2 != null){
            s += l2.val;
            l2 = l2.next;
        }
        String res = "";
        int r = 0;
        if(s.length() != f.length()){
            String g = (s.length() < f.length()) ? f : s;
             String l = (s.length() < f.length()) ? s : f;
             r = g.length();
            
            while(r > l.length()){
                ans+= g.charAt(g.length() - r);
                r--;
            }
        }
     */  
        /*
      long ans = Long.parseLong(f) + Long.parseLong(s);
        /*
        System.out.println(f);
           System.out.println(s);
              System.out.println(ans);
              */
              /*
        String res = Long.toString(ans);
        ListNode head = new ListNode();
        ListNode runner = head;
        for(int i = 0; i < res.length(); i++){
            runner.val = Integer.parseInt(String.valueOf((res.charAt(i))));
            if(i != res.length() - 1 && runner.next == null){
                ListNode temp = new ListNode();
                runner.next = temp;
            }
            runner = runner.next;
        }
        */
        ListNode f = ReverseList(l1);
        ListNode s = ReverseList(l2);
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(f != null || s != null){
            int ans = temp.val;
           
            if(f != null){
                ans += f.val;
            }
             if(s != null){
                ans += s.val;
            }
           
             temp.val = ans % 10 ;
            ListNode nxt =  new ListNode(ans / 10);
            temp.next = nxt;
            temp = temp.next;

            if(f!=null){
                f = f.next;
            }
            if(s != null){
                s = s.next;
            }
        }
        head = ReverseList(head);

        return (head.val == 0 && head.next != null) ? head.next : head;
    }
    ListNode ReverseList(ListNode x){
        ListNode prev = null;
        ListNode cur = x;
      //  prev.next = cur;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;      
        }
        return prev;
    }
}