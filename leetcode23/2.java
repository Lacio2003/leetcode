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
    思路:使用分治思想进行合并
        递归的返回值:合并之后的链表的头部
        递归的参数:一个是数组，其余的两个位置
        递归的结束条件:两个位置相邻的时候。
    时间复杂度:O(nlogn),合并需要花费O(n)的时间，logn是遍历数组的时间。
    空间复杂度:O(logn)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left ,int right) {
        // 递归的结束条件
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }

        // 每次二分
        int mid = left + ((right - left) >> 1);
        ListNode first = merge(lists, left , mid);
        ListNode second = merge(lists, mid + 1, right);
        return mergeTowLists(first, second);
    }

    /**
     * @param list1 要合并的第一个链表
     * @param list2 要合并的第二个链表
     * @return 合并之后的链表。
     */
    private ListNode mergeTowLists(ListNode list1, ListNode list2) {
        // 指向list1和list2的两个指针
        ListNode p1 = list1, p2 = list2;

        // 存储结点
        ListNode newHead = new ListNode(), cur = newHead;
        while (null != p1 && null != p2) {
            // 每一次链接比较小的结点
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        // 链接剩余的结点
        cur.next = null != p1 ? p1 : p2;
        return newHead.next;
    }
}