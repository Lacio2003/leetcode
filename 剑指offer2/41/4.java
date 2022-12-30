/**
 * 思路：使用数组来存储数据元素，运用循环数组的思想对数组中元素进行赋值
 * 时间复杂度：O(1)
 * 空间复杂度：O(n)
 */

class MovingAverage {
    /**
     * 使用一个数组存储数据元素
     */
    private int[] nums;
    /**
     * 数据中元素的个数
     */
    int capacity;
    /**
     * 数组中元素的和
     */
    double sum;
    /**
     * 数组下标的指针
     */
    int point;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new int[size];
        capacity = 0;
        sum = 0;
        // 为了方便使用，初始化为-1
        point = -1;
    }
    
    public double next(int val) {
        // 更新capcacity
        capacity = (++capacity) > nums.length ? nums.length : capacity;
        // 加入当前元素
        sum += val;
        // 减去即将赋值的位置的值
        sum -= nums[(++point) % nums.length];
        // 将新的元素加入到数组当中
        nums[point % nums.length] = val;

        // 返回平均值
        return sum / capacity;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */