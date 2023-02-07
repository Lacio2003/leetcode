/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    层序遍历，先将每一层的链表，存储到一个list当中，然后将list转换为数组
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        // 1.准备变量
        // 存储每一层的结点的链表
        List<ListNode> list = new ArrayList<>();
        // 层序遍历使用的队列
        Deque<TreeNode> queue = new ArrayDeque<>();

        // 2.开始层序遍历
        queue.offer(tree);
        while (!queue.isEmpty()) {
            // 创建当前层的指针
            // 为了方便操作，设置了一个虚拟的头节点
            ListNode curLevel = new ListNode(0), tail = curLevel;
            // 遍历当前层所有的结点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 获取结点
                TreeNode curNode = queue.poll();
                // 链接到指针上
                tail.next = new ListNode(curNode.val);
                tail = tail.next;
                // 压入左右子树
                if (null != curNode.left) {
                    queue.offer(curNode.left);
                }
                if (null != curNode.right) {
                    queue.offer(curNode.right);
                }
            }

            // 将当前层的链表加入到队列当中
            list.add(curLevel);
        }

        // 3.将list转换为数组
        int n = list.size();
        ListNode[] ans = new ListNode[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i).next;
        }

        return ans;
    }
}