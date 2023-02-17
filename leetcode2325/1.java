/*
    使用Map作为存储每一个字母之间的对应关系

    时间复杂度:O(m + n)
    空间复杂度:O(n)
*/
class Solution {
    public String decodeMessage(String key, String message) {
        // 将每一个字母的映射进行存储
        Map<Character, Character> hash = new HashMap<>();
        int lowerCase = 0;

        int keyLen = key.length();
        for (int i = 0; i < keyLen; i++) {
            char cur = key.charAt(i);
            if (' ' != cur && !hash.containsKey(cur)) {
                hash.put(cur, (char)(lowerCase + 'a'));
                lowerCase++;
            }
        }

        // decode message
        StringBuilder ans = new StringBuilder();
        int messageLen = message.length();
        for (int i = 0; i < messageLen; i++) {
            char cur = message.charAt(i);
            ans.append(' ' == cur ? ' ' : hash.get(cur));
        }

        return ans.toString();
    }
}