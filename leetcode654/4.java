/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
    将数组构建成一个线段树，然后构建TreeNode的过程中查询指定区间的最大值
    因为线段树只能够返回最大值，无法返回最大值所在的原来数组的下标，所以需要使用哈希表，将数据和对应的下标进行存储。这样就可以获取最大值的下标了。
    时间复杂度:O(nlogn)
    空间复杂度:O(n)
*/
class Solution {
    int[] hash = new int[1010];
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        // 将所有的数字放到哈希表当中，以便后面的查找
        for (int i = 0; i < n; i++) {
            hash[nums[i]] = i;
        }

        SegmentTree segmentTree = new SegmentTree(nums);
        return dfs(nums, 0, n - 1, segmentTree);
    }

    private TreeNode dfs(int[] nums, int l, int r, SegmentTree segmentTree) {
        if (l > r) {
            return null;
        }

        // 在[l, r]区间之内获取最大值
        int max = segmentTree.query(l, r), idx = hash[max];
        TreeNode newNode = new TreeNode(max);
        newNode.left = dfs(nums, l, idx - 1, segmentTree);
        newNode.right = dfs(nums, idx + 1, r, segmentTree);

        return newNode;
    }
}

class SegmentTree{
    /**
     * 存储线段树的数组
     */
    private int[] segmentArray;

    /**
     * 存储原来的数组里面的数据
     */
    private int[] originalData;

    public SegmentTree(int[] originalData) {
        // 初始化数组
        int n = originalData.length;
        this.originalData = new int[n];
        this.segmentArray = new int[4 * n];

        // 赋值数据
        System.arraycopy(originalData, 0, this.originalData, 0, n);

        // 构建线段树
        buildSegment(0, 0, n - 1);
    }

    /**
     * 根据区间构建线段树
     * @param treeIndex 线段树的下标
     * @param l 区间的左边界
     * @param r 区间的右边界
     */
    private void buildSegment(int treeIndex, int l, int r) {
        // 到达叶子节点
        if (l == r) {
            segmentArray[treeIndex] = originalData[l];
            return;
        }

        int mid = l + ((r - l) >>> 1);
        // 建立左子树
        buildSegment(treeIndex * 2 + 1, l, mid);
        // 建立右子树
        buildSegment(treeIndex * 2 + 2, mid + 1, r);

        segmentArray[treeIndex] = Math.max(segmentArray[treeIndex * 2 + 1], segmentArray[treeIndex * 2 + 2]);
    }

    /**
     * 查询某一区间的和
     * @param l 区间的左边界
     * @param r 区间的右边界
     * @return 区间的和
     */
    public int query(int l, int r) {
        int n = this.originalData.length;
        if (l > r || l < 0 || l >= n || r >= n) {
            throw new IllegalArgumentException("Index is illegal");
        }

        // 调用查询语句
        return query(0, 0, originalData.length - 1, l, r);
    }

    /**
     * 查询某一个区间的和的具体过程
     * @param treeIndex 线段树数组的下标
     * @param l 当前区间的左边界
     * @param r  当前区间的右边界
     * @param queryL 要查询区间的左边界
     * @param queryR 要查询区间的右边界
     * @return 查询的区间的和
     */
    private int query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (queryL <= l && queryR >= r) {
            // 说明当前区间是[queryL, queryR]的子区间
            return segmentArray[treeIndex];
        }

        int mid = l + ((r - l) >>> 1), max = -1;

        if (queryL <= mid) {
            // 左边的区间是要查询的区间的子区间
            max = Math.max(max, query(treeIndex * 2 + 1, l, mid, queryL, queryR));
        }

        if (queryR > mid) {
            // 右区间是要查询的区间的子区间
            max = Math.max(query(treeIndex * 2 + 2, mid + 1, r, queryL, queryR), max);
        }

        return max;
    }
}
