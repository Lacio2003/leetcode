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

/**
 * 思路:递归实现，
 *  使用两个指针，一个先递归到最后，然后和另外一个一个结点一个结点的进行比对。如果false，返回false
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    // 从头开始遍历的指针
    ListNode fontPointer = null;
    public boolean isPalindrome(ListNode head) {
        fontPointer = head;
        return recursive(head);
    }

    private boolean recursive(ListNode currNode) {
        if (null != currNode) {
            // 如果上一个返回false，或者这次的对比不相等，那么直接返回false。
            if (!recursive(currNode.next) || currNode.val != fontPointer.val) {
                return false;
            }

            fontPointer = fontPointer.next;
        }

        return true;
    }


}