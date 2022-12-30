/**
 * 思路：暴力破解。获取每一个字符的行数，然后进行比较。如果一个单词的所有的字符的
 * 行数相等，则说明是一行符合要求。加入到答案当中。
 * 时间复杂度：O(L) 所有字符串的长度
 * 空间复杂度：O(1) 不算返回答案的字符串的数量
 */
class Solution {
    public String[] findWords(String[] words) {
        // 存储答案的集合
        List<String> ans = new ArrayList<>();

        // 遍历字符串数组，判断元素
        for (String e : words) {
            // 为了方便比对，将所有的字母转换为小写字母
            String upper = e.toLowerCase();
            // 获得第一个字母的行数
            int line = getLine(upper.charAt(0) + "");
            // 判断当前单词的字符是否是在同一行上。
            boolean is = true;
            for (int i = 1; i < upper.length(); i++) {
                if (getLine(upper.charAt(i) + "") != line) {
                    is = false;
                    break;
                }
            }

            if (is) {
                // 一个单词的所有字母在一行上
                ans.add(e);
            }
        }

        // 返回最后的答案
        return ans.toArray(new String[ans.size()]);
    }

    /**
     * 获取一个字符在键盘上的行数。
     * @param letter 要判断行数的字符
     * @return 返回当前字母所在的行数
     */
    private int getLine(String letter) {
        if ("qwertyuiop".contains(letter)) {
            return 1;
        } else if ("asdfghjkl".contains(letter)) {
            return 2;
        } else {
            return 3;
        }
    }
}