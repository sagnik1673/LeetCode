// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
// After doing so, return the head of the final linked list.  You may return any such answer.

// (Note that in the examples below, all sequences are serializations of ListNode objects.)

// Example 1:
// Input: head = [1,2,-3,3,1]
// Output: [3,1]
// Note: The answer [1,2,1] would also be accepted.

// Example 2:
// Input: head = [1,2,3,-3,4]
// Output: [1,2,4]

// Example 3:
// Input: head = [1,2,3,-3,-2]
// Output: [1]

// Constraints:
// 	The given linked list will contain between 1 and 1000 nodes.
// 	Each node in the linked list has -1000 <= node.val <= 1000.

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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode current = front;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        while (current != null) {
            // Add current's value to the prefix sum
            prefixSum += current.val;

            // If prefixSum is already in  the hashmap, 
            // we have found a zero-sum sequence:
             if (prefixSumToNode.containsKey(prefixSum)) {
                ListNode prev = prefixSumToNode.get(prefixSum);
                current = prev.next;

                // Delete zero sum nodes from hashmap
                // to prevent incorrect deletions from linked list
                int p =  prefixSum + current.val;
                while (p != prefixSum) {
                    prefixSumToNode.remove(p); 
                    current = current.next;
                    p +=  current.val;
                }

                // Make connection from the node before 
                // the zero sum sequence to the node after
                prev.next = current.next;
            } else {
                // Add new prefixSum to hashmap
                prefixSumToNode.put(prefixSum, current);
            }
            // Progress to next element in list
            current = current.next;
        }
        return front.next;
    }
}
