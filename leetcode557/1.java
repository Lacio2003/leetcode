/*
    如何反转单词
        可以使用双指针解决
    保留单词的相对顺序
        按序遍历即可
    
    思路:
        1.按照空格进行切割
        2.反转每一步，然后加到容器里面，
        3.最后返回容器
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public String reverseWords(String s) {
        // 按照空格切割字符串
        String[] strings = s.split(" ");

        // 反转每一个单词，然后加到容器里面
        StringBuilder ans = new StringBuilder();
        for (String str : strings) {
            int n = str.length();
            // 倒着加入
            for (int i = n - 1; i > -1; i--) {
                ans.append(str.charAt(i));
            }
            ans.append(" ");
        }

        // 删掉最后位置的一个空格
        ans.deleteCharAt(ans.length() - 1);
        // 返回容器
        return ans.toString();
    }
}