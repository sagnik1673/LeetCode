// Given the head of a linked list, remove the nth node from the end of the list and return its head.
  
// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []
  
// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode x = head;
        int cnt = 0;
        while (x != null) {
            x = x.next;
            cnt++;
        }
        if (cnt == n) {
            ListNode temp = head.next;
            head = null;
            return temp;
        }
        x = head;
        int m = cnt - n;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int i = 0; i < m; i++) {
            temp.next = x;
            temp = temp.next;
            x = x.next;
        }
        temp.next = x.next;
        ListNode result = dummy.next;
        dummy = null;
        return result;
    }
}
