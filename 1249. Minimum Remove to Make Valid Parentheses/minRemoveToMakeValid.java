// Given a string s of '(' , ')' and lowercase English characters.
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
// Formally, a parentheses string is valid if and only if:
//	It is the empty string, contains only lowercase characters, or
//	It can be written as AB (A concatenated with B), where A and B are valid strings, or
//	It can be written as (A), where A is a valid string.

// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

// Constraints:
//	1 <= s.length <= 10^5
//	s[i] is either'(' , ')', or lowercase English letter.

class Solution {
    public String minRemoveToMakeValid(String s) {
        // Initialize counts for left and right parentheses
        int leftCount = 0;
        int rightCount = 0;

        // Use a stack to keep track of valid parentheses
        Stack<Character> stack = new Stack<>();

        // Pass 1: Iterate through the string and process parentheses
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Increment count for left parentheses
            if (currentChar == '(') {
                leftCount++;
            }
            // Increment count for right parentheses
            if (currentChar == ')') {
                rightCount++;
            }

            // If there are more right parentheses than left, skip the current right parenthesis
            if (rightCount > leftCount) {
                rightCount--; // Decrease right count
                continue;     // Skip processing this right parenthesis
            } else {
                stack.push(currentChar); // Add valid parentheses to the stack
            }
        }

        // Pass 2: Reconstruct the string using the valid parentheses in the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            char currentChar = stack.pop();
            // If there are more left parentheses than right, skip the current left parenthesis
            if (leftCount > rightCount && currentChar == '(') {
                leftCount--; // Decrease left count
                // Do nothing, skip this left parenthesis
            } else {
                result.append(currentChar); // Add valid parentheses to the result
            }
        }

        // Reverse the result string and return
        return result.reverse().toString();
    }
}
