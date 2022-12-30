/*
 * 思路：将请求存储在一个队列当中。将新的请求添加到队尾。
 * 每次添加一个新的请求，从对头开始检查队列将不合法的请求移除。
 * 最后返回队列大小即可。
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */

class RecentCounter {

    // 使用队列进行存储
    Deque<Integer> queue = new LinkedList<>();

    public RecentCounter() {

    }
    
    public int ping(int t) {
        // 将当前元素添加进队尾
        queue.addLast(t);

        // 将队列当中的不在范围的请求全部移除
        while (queue.getFirst() < t - 3000) {
            queue.pollFirst();
        }

        // 返回队列的个数
        return queue.size();
    }
}
