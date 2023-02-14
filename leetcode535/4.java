/*
    website:https://leetcode.cn/problems/encode-and-decode-tinyurl/solutions/1632000/by-ac_oier-ca6o/

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
public class Codec {
    // 存储映射关系的哈希表
    // encodeString longUrl
    // longUrl, encodeString
    Map<String, String> database = new HashMap<>(), urlToKey = new HashMap<>();
    final String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    final String prefix = "http://tinyurl.com/";
    final int k = 10;
    Random random = new Random();
        
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (!urlToKey.containsKey(longUrl)) {
            // 生成key
            char[] cs = new char[k];
            for (int i = 0; i < k; i++) {
                cs[i] = str.charAt(random.nextInt(0, k + 1));
            }

            String key = prefix + String.valueOf(cs);
            if (database.containsKey(key)) {
                continue;
            }

            database.put(key, longUrl);
            urlToKey.put(longUrl, key);
        }

        return urlToKey.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return database.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));