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

/**
 * 思路:
 *  1.准备一个哈希表用来存放节点
 *  2.遍历链表，并将节点放入到哈希表当中，如果当前节点再哈希表当中出现过，就说明有环
 *  3.如果可以成功遍历，就说明没有环
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 1.准备一个存放节点的哈希表
        Set<ListNode> hash = new HashSet<>();

        // 2.遍历链表，将节点放到哈希表当中并进行检验
        for (ListNode p = head; p != null; p = p.next) {
            if (hash.contains(p)) {
                return true;
            }
            hash.add(p);
        }

        // 3.程序可以执行到这里，说明没有环
        return false;
    }
}