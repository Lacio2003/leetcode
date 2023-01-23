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
        1.遍历链表，查看下一个节点的是不是在哈希表当中出现过，
        2.如果不是，则移动指针，将节点的值放入哈希表当中
        3.如果使，则删除下一个节点
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        // 排序不合法的情况
        if (null == head || null == head.next) {
            return head;
        }
        // 1.存储节点的哈希表
        Set<Integer> hash = new HashSet<>();
        // 第一个节点不可能删除，直接加入
        hash.add(head.val);

        // 2.遍历链表，查看下一个节点的是不是在哈希表当中出现过
        for (ListNode p = head; null != p.next;) {
            if (hash.contains(p.next.val)) {
                // 下一个节点是一个重复节点
                // 进行节点的删除
                p.next = p.next.next;
            } else {
                // 下一个节点不是一个重复节点
                // 将节点放入到哈希表当中
                hash.add(p.next.val);
                p = p.next;
            }
        }

        return head;
    }
}