/** 
 * First cut the string according the the slash.Iterate through the cut string, if you encounter .. just pop the elements at the top of the stack.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public String simplifyPath(String path) {
        // The stack.
        Deque<String> stack = new LinkedList<>();

        for (String e : path.split("/")) {
            if (e.equals("..")) {
                // Go back to the previous directory.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!e.isEmpty() && !e.equals(".")) {
                // Push the current directory.
                stack.push(e);
            }
        }

        String ans = "";
        for (String e : stack) {
            // Add the slash back.
            ans = "/" + e + ans;
        }

        return ans.isEmpty() ? "/" : ans;

    }
}