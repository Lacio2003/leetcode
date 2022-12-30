/**
 * 思路：事先计算出所有的字符所在的行数。然后遍历字符串数组判断每一个字符的行数。
 * 时间复杂度:O(L)所有字符串的长度
 * 空间复杂度:O(C)英文字母的个数
 */
class Solution {
    public String[] findWords(String[] words) {
        // 存储最后答案的集合
        List<String> ans = new ArrayList<>();
        // 每一个字符所在的行号
        String rowIdx = "12210111011122000010020202";

        for (String e : words) {
            // 为了方便寻找，将所有的字母转换为小写
            String lower = e.toLowerCase();
            // 获取第一个字母的行号
            char idx = rowIdx.charAt(lower.charAt(0) - 'a');
            // 使用一个变量判断所有的字母是否在同一行
            boolean is = true;
            // 判断当前单词中其他的字母是否在同一行
            for (int i = lower.length() - 1; i > 0; i--) {
                // 判断当前字符的行数是否和第一个字符相同
                if (rowIdx.charAt(lower.charAt(i) - 'a') != idx) {
                    is = false;
                    break;
                }
            }

            if (is) {
                // 如果一个单词当中所有的字符在同一行，那么加入最后的答案。
                ans.add(e);
            }
        }

        // 利用List的toArray可以将List转换为数组
        return ans.toArray(new String[ans.size()]);
    }
}