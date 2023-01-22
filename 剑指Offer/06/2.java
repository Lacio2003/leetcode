/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    思路:
        1.准备一个栈，遍历链表，将所有的结点放入栈中
        2.利用栈的大小新建一个数组
        3.将所有的结点弹栈，放入到数组当中
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[]{};
        }
        // 1.准备一个栈，遍历链表，将所有的结点放入到栈当中
        Deque<Integer> stack = new ArrayDeque<>();

        for (ListNode p = head; null != p; p = p.next) {
            stack.push(p.val);
        }

        // 2.利用栈的大小新建一个数组
        int[] ans = new int[stack.size()];

        // 3.将所有的结点弹栈，放入到数组当中
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}