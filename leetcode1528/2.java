/**
 * 思路：遍历s和indices，对s进行原地修改。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (indices[i] != i) {
                // 存储当前字符串
                char ch = chars[i];
                // 存储要交换的位置
                int idx = indices[i];
                // 除非idx等于i否则要一直交换
                while (idx != i) {
                    // 交换两个字母
                    char temp = ch;
                    ch = chars[idx];
                    chars[idx] = temp;

                    // 交换两个位置
                    int intTemp = idx;
                    idx = indices[idx];
                    indices[intTemp] = intTemp;

                }
                // 找到正确的字母和位置，进行赋值
                chars[i] = ch;
                indices[i] = i;
            }
        }

        return new String(chars);
    }
}