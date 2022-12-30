/**
 * 思路：按照题目暴力破解
 * 时间复杂度：O(n*m)，n为字符串S的长度，m为c在s中的数量
 * 空间复杂度：O(n)。不算返回答案的数组
 */
class Solution {
    public int[] shortestToChar(String s, char c) {
        // 为了方便遍历，将s转换为字符数组
        char[] sArray = s.toCharArray();
        // s中c的下标
        List<Integer> indexs = getIndex(sArray, c);
        // 存储答案的数组
        int[] ans = new int[sArray.length];
        // 答案数组的下标
        int index = 0;
        for (int i = 0; i < sArray.length; i++) {
            // 寻找当前字符离最近的c的距离
            int minValue = Math.abs(i - indexs.get(0));
            for (int j = indexs.size() - 1; j > 0; j--) {
                int divide = Math.abs(i - indexs.get(j));
                minValue = minValue > divide ? divide : minValue;
            }

            // 将最小距离存入数组
            ans[index++] = minValue;
        }

        return ans;
    }

    /**
     * 得到s当中c字符的下标
     * @param s 字符串S
     * @param c 要寻找的字符
     * @return s中c字符的下标
     */
    private List<Integer> getIndex(char[] s, char c) {
        // 存储下标的集合
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == c) {
                indexs.add(i);
            }
        }
        return indexs;
    }
}