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

/*
    可以先将链表存储到list当中，然后利用双指针， 一头一尾开始构建

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public void reorderList(ListNode head) {
        // 先将所有的结点放到list当中
        List<ListNode> lists = new ArrayList<>();
        ListNode cur = head;

        while (null != cur) {
            ListNode next = cur.next;
            cur.next = null;
            lists.add(cur);
            cur = next;
        }

        // 利用双指针进行构建
        ListNode newHead = new ListNode(), tail = newHead;
        int left = 0, right = lists.size() - 1;
        while (left <= right) {
            tail.next = lists.get(left);
            left++;
            tail = tail.next;

            if (left < right) {
                tail.next = lists.get(right);
                right--;
                tail = tail.next;
            }
        }

        head = newHead.next;
    }
}