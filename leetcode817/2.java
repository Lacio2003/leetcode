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
    思路:从链表下手，不要从nums下手。
        1.遍历链表，查看连续的链表是否在当前元素是否在nums中出现过。
        2.如果没有出现过，则不是，直接移动指针。
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        // 为了降低时间复杂度，将nums中的数据放入哈希表当中
        Set<Integer> hash = new HashSet<>();
        for (int e : nums) {
            hash.add(e);
        }

        // 遍历链表
        int ans = 0;
        // 标记连续的链表
        boolean is = false;
        for (ListNode p = head; null != p; p = p.next) {
            if (hash.contains(p.val)) {
                if (!is) {
                    is = true;
                    ans++;
                }
            } else {
                is = false;
            }
        }

        return ans;

    }
}