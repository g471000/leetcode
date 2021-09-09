import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

		// while, next...... n times
    public boolean hasCycle1(ListNode head) {
       if(head == null || head.next == null){ return false; }
       int count = 0;
       while(head != null){
        if(count < 10000) {
        	head = head.next;
          count++;
        } else {
        	return true;
        }
       }
       return false;
    }
    
    // Set? << node pointer
    public boolean hasCycle2(ListNode head) {
        if(head == null && head.next == null) return false;
        
        HashSet<ListNode> listPointers = new HashSet<ListNode>();        
        ListNode curr = head;
        
        while(curr != null){
            if(listPointers.contains(curr)) {
                return true;
            } 
            listPointers.add(curr);
            curr = curr.next;
        }
        return false;
    }
    
    public boolean hasCycle3(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(fast != null && fast.next != null){
          if(slow == fast){
              return true;
          }
          slow = slow.next;
          fast = fast.next.next;
        }
        return false;
    }
}

