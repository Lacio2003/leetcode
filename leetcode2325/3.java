/*
    使用Map作为存储每一个字母之间的对应关系

    时间复杂度:O(m + n)
    空间复杂度:O(n)
*/
class Solution {
    public String decodeMessage(String key, String message) {
        // 将每一个字母的映射进行存储
        char[] diagram = new char[26];
        int lowerCase = 0;

        int keyLen = key.length();
        for (int i = 0; i < keyLen; i++) {
            char cur = key.charAt(i);
            if (' ' != cur && diagram[cur - 'a'] == '\u0000') {
                diagram[cur - 'a'] = (char)(lowerCase + 'a');
                lowerCase++;
            }
        }


        // decode message
        int messageLen = message.length();
        // 利用数组进行存储
        char[] ans = new char[messageLen];
        for (int i = 0; i < messageLen; i++) {
            char cur = message.charAt(i);
            ans[i] = cur == ' ' ? ' ' : diagram[cur - 'a'];
        }

        return String.valueOf(ans);
    }
}