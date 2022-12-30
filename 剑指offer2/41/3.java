/**
 * 思路：使用队列存储数据元素。唯一不同的是，使用一个变量sum来存储元素的和。从而降低时间复杂度。
 * 时间复杂度：O(1)
 * 空间复杂度：O(n)
 */

class MovingAverage {
    /**
     * 存储数据元素的队列
     */
    private Deque<Integer> queue;
    /**
     * 数据元素的个数的限制
     */
    int size;
    /**
     * 队列中元素的和
     */
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        // 存储元素
        queue.offer(val);
        sum += val;
        if (queue.size() > size) {
            // 队列的元素超过限界，将元素弹出。
            sum -= queue.poll();
        }
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */