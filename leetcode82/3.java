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
    思路:
        1.设置一个哑结点
        2.准备一个哈希表。
        3.遍历一遍链表，将所有的结点的值以及对应出现的次数放在哈希表当中
        4.再次遍历链表，检查当前节点下一个结点的出现次数如果不是1，则就要删除
    时间复杂度:O(n)
    空间复杂度:O(n)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 1.设置一个哑结点
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        // 2.准备一个哈希表
        Map<Integer, Integer> hash = new HashMap<>();

        // 3.遍历一次链表，将所有的结点的值以及对应的此处放在哈希表当中
        for (ListNode p = head.next; null != p; p = p.next) {
            hash.put(p.val, hash.getOrDefault(p.val, 0) + 1);
        }

        // 4.再次遍历链表，删除出现多次的结点
        for (ListNode p = head; null != p.next;) {
            if (hash.get(p.next.val) > 1) {
                // 下一个节点是重复结点
                int x = p.next.val;
                // 寻找下一个的结点
                ListNode next = p.next;
                while (null != next && x == next.val) {
                    next = next.next;
                }
                // 链接结点
                p.next = next;
            } else {
                p = p.next;
            }
        }

        return head.next;
    }
}