/*
    根据题意可以直到，只有a和b的情况下，删除次数最多是两次。
    所以，我们只要判断这个字符串可不可以一次删除就可以了。即:判断这个字符串整体是不是一个回文串
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2;
            }
        }

        return 1;
    }
}