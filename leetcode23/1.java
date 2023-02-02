import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // 递归的结束条件
        // 排除一些特殊的情况
        if (null == head || null == head.next || k == 1) {
            return head;
        }

        // 获取链表的后继节点
        ListNode succ = head;
        for (int i = 0; i < k; i++) {
            if (null == succ) {
                // 说明剩余的结点不够k个，直接返回
                return head;
            }
            succ = succ.next;
        }

        // 程序可以执行到这里，说明剩余的结点一定是够k个的
        // 进行链表的反转
        ListNode pre = null, cur = head;
        while (cur != succ) {
            ListNode next = cur.next;
            // 改变连接
            cur.next = pre;
            // 移动指针
            pre = cur;
            cur = next;
        }

        head.next = reverseKGroup(succ, k);
        return pre;
    }
}