/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * 思路:
 *  1.先遍历一个链表，将所有的节点放入到哈希表当中。
 *  2.再遍历另一个链表，检查当前节点是否再哈希表当中出现过。如果出现过，说明两个链表相交，当前节点解释相交开始的位置
 *  3.如果所有的节点都没有再哈希表当中出现过，那么直接返回Null。
 * 时间复杂度:O(n)
 * 空间夫再度:O(n)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 存储节点的哈希表
        Set<ListNode> hash = new HashSet<>();

        // 1.遍历headA，将所有的节点都放入到headA当中
        for (ListNode p = headA; p != null; p = p.next) {
            hash.add(p);
        }

        // 2.遍历headB，查看节点是否在哈希表当中出现过
        for (ListNode p = headB; p != null; p = p.next) {
            if (hash.contains(p)) {
                return p;
            }
        }

        // 3.所有节点都没有在哈希表当中出现过，说明不相交，直接返回null。
        return null;
    }
}