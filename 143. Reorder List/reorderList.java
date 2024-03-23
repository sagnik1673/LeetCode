// You are given the head of a singly linked-list. The list can be represented as:
// 	L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// 	L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Example 2:
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]

// Constraints:
// 	The number of nodes in the list is in the range [1, 5 * 104].
// 	1 <= Node.val <= 1000

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode mid = getMid(head);
        ListNode hSecond = reverse(mid);
        ListNode hFirst = head;
        while(hFirst != null && hSecond != null) {
            ListNode temp = hFirst.next;
            hFirst.next = hSecond;
            hFirst = temp;
            temp = hSecond.next;
            hSecond.next = hFirst;
            hSecond = temp;
        }
        if(hFirst != null)
            hFirst.next = null;
    }

    public ListNode getMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode mid) {
        ListNode prev = null;
        ListNode present = mid;
        ListNode then = present.next;
        while(present != null) {
            present.next = prev;
            prev = present;
            present = then;
            if(then != null)
            then = then.next;
        }
        return prev;
    }
}
