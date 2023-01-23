/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
    思路:
        1.准备一个哈希表
        2.遍历链表，如果当前节点没有在链表当中出现过，则加入这个节点。
        3.如果有，当前节点就是入环的第一个节点。
        4.如果迭代可以成功结束，说明没有环，直接返回null
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 排除不合法的情况
        if (null == head) {
            return null;
        }

        // 1.准备一个哈希表
        Set<ListNode> hash = new HashSet<>();

        // 2.遍历链表，如果当前节点没有在链表当中出现过，则加入这个节点。
        for (ListNode p = head; null != p; p = p.next) {
            if (hash.contains(p)) {
                return p;
            }
            hash.add(p);
        }

        return null;
    }
}