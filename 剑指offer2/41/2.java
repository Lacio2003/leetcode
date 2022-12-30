/**
 * 思路：使用数组来存储数据元素。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class MovingAverage {
    // 存储元素的数组
    private int[] nums;
    // 数组内元素的个数
    private int size;
    // 数组的指针
    private int point = -1;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new int[size];
    }
    
    public double next(int val) {
        // 更新size
        size++;
        size = size > nums.length ? nums.length : size;
        // 将新元素加入数组
        nums[(++point) % nums.length] = val;

        // 对数组求和
        double sum = 0;
        for (int e : nums) {
            sum += e;
        }
        return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */