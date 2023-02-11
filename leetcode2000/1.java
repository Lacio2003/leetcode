/*
    找到ch所在的位置:循环遍历解决
    反转从开头到ch所在的位置
        提起将word变成字符数组，然后利用字符数组的双指针进行反转
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public String reversePrefix(String word, char ch) {
        // 将word变成字符数组
        char[] chars = word.toCharArray();
        int n = chars.length;

        // 找到ch所在的位置
        int index = 0;
        while (index < n && chars[index] != ch) {
            index++;
        }

        // 不存在ch，直接返回word
        if (index >= n) {
            return word;
        }

        // 反转开头到ch所在的位置
        for (int i = 0; i <= (index >> 1); i++) {
            char temp = chars[i];
            chars[i] = chars[index - i];
            chars[index - i] = temp;
        }

        return new String(chars);
    }
}