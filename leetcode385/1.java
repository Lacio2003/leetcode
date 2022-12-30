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
 *     // Set this NestedInteger to hold a single intrege.
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
  * Use the stack simulate.
  * Runtime complexity:O(n)
  * Space complexity:O(n)
  */
class Solution {
    // The mark is a mark
    static NestedInteger mark = new NestedInteger(0);
    public NestedInteger deserialize(String s) {
        // The stack.
        Deque<NestedInteger> stack = new ArrayDeque<>();
        // For easy of use, Convert the string to the character array.
        char[] arr = s.toCharArray();
        // The i is suscript of the arr.
        // The len is the length of the arr.
        int i = 0, len = arr.length;

        // Traversal the String s.
        while (i < len) {
            if (arr[i] == ',') {
                // If the current character is a ',', skip it directly.
                i++;
                continue;
            } else if (arr[i] == '-' || (arr[i] >= '0' && arr[i] <= '9')) {
                // Encounter a string of numbers.
                // Take out the numbers.
                int j = arr[i] == '-' ? i + 1 : i, num = 0;
                while (j < len && (arr[j] >= '0' && arr[j] <= '9')) {
                    num = num * 10 + arr[j] - '0';
                    j++;
                }
                // Add the current number.
                stack.addLast(new NestedInteger(arr[i] != '-' ? num : -num));
                i = j;
            } else if (arr[i] == '[') {
                // Encounter a new NestedInteger object.
                stack.addLast(new NestedInteger());
                // Push a mark.
                stack.addLast(mark);
                i++;
            } else {
                // Encounter the ']'.
                List<NestedInteger> temp = new ArrayList<>();
                // Take out all the objects in this segement.
                while (!stack.isEmpty()) {
                    NestedInteger cur = stack.pollLast();
                    if (cur == mark) {
                        break;
                    }
                    temp.add(cur);
                }

                // Add the object to the NestedInteger.
                for (int j = temp.size() - 1; j >= 0; j--) {
                    stack.peekLast().add(temp.get(j));
                }
                i++;
            }
        }

        return stack.peekLast();
    }
}