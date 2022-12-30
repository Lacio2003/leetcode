/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 /**
  * Use recursion.
  * Runtime complexity:O(n)
  * Space complexity:O(n)
  */
class Solution {
    // The index of the s.
    int index = 0;
    public NestedInteger deserialize(String s) {
        if (s.charAt(index) == '[') {
            // Encounter a new NestedInteger.
            index++;
            NestedInteger cur = new NestedInteger();
            while (s.charAt(index) != ']') {
                // Get a number.
                cur.add(deserialize(s));
                // Skip the ,.
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return cur;
        } else {
            // Get the current number.
            // The sign of the number.
            boolean sign = true;
            if (s.charAt(index) == '-') {
                // The current number is negative.
                sign = false;
                index++;
            }

            // The num stores the current number.
            int len = s.length(), num = 0;
            while (index < len && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }

            return new NestedInteger(sign ? num : -num);
        }
    }
}