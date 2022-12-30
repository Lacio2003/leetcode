class RecentCounter {
    /*
     * 思路：将每一次的请求存储到一个集合当中。然后遍历集合判断当前请求是否符合左右边界。
     * 将不符合的请求移除。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
    */

    // 存储请求。
    List<Integer> pingCounts = new ArrayList<>();

    public RecentCounter() {

    }
    
    public int ping(int t) {
        // 当前请求的左右边界
        int leftBound = t - 3000, rightBound = t;

        // 记录请求数
        int count = 1;
        // 遍历集合寻找在范围内的请求
        for (int i = 0; i < pingCounts.size();) {
            int nowNums = pingCounts.get(i);
            if (nowNums >= leftBound && nowNums <= rightBound) {
                // 请求在范围之内，count++
                count++;
                i++;
            } else {
                // 请求不在范围之内，因为请求时不断增大的。那么意味着之后的请求，当前请求也不可以在范围之内，所以直接移除即可。
                pingCounts.remove(i);
            }
        }

        // 将当前请求添加在范围之内
        pingCounts.add(t);

        return count;
    }
}
