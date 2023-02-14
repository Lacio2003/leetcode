/*
    利用哈希函数

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
public class Codec {
    static final int K1 = 1117;
    static final int K2 = 1000000007;

    // 这个是用来查的。
    private Map<Integer, String> database = new HashMap<>();
    // 这个是解决重复的问题的。
    private Map<String, Integer> urlToKey = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // 查找是否是重复的longUrl
        if (urlToKey.containsKey(longUrl)) {
            return "http://tinyurl.com/" + urlToKey.get(longUrl);
        }

        // longUrl不重复，那么生成哈希值
        int key = 0;
        long base = 1;

        // 计算哈希值
        int n = longUrl.length();
        for (int i = 0; i < n; i++) {
            char cur = longUrl.charAt(i);
            key = (int)((key + (long)cur * base) % K2);
            base = (base * K1) % K2;
        }

        // 防止哈希值发生冲突
        while (database.containsKey(key)) {
            key = (key + 1) % K2;
        }

        database.put(key, longUrl);
        urlToKey.put(longUrl, key);

        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(index));
        return database.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));