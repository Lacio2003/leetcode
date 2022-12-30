/**
 * 思路：使用队列存储数据元素，并使用一个变量size来判断元素的个数是否超过限制。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class MovingAverage {
    // 用来存放数据元素的队列
    private Deque<Integer> queue;
    // 记录元素的个数
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        // 添加元素
        queue.offer(val);
        // 检查元素的个数是否超过长度
        if (queue.size() > size) {
            queue.poll();
        }
        // 计算和
        double sum = 0;
        for (Integer e : queue) {
            sum += e;
        }

        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */