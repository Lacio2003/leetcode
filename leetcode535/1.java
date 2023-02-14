/*
    可以利用id自增的方法来进行加密
    具体方法:
        进行编码的时候，使用id自增的方式:http://tinyurl.com/id
        进行解码的时候，将id取出来，然后再哈希表当中进行存储。
    
    时间复杂度:O(1)
    空间复杂度:O(n)
*/
public class Codec {
    // 存储shrotUrl的id和longUrl和对应关系的哈希表
    Map<Integer, String> database = new HashMap<>();
    int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        database.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // 取出id
        int index = shortUrl.lastIndexOf('/') + 1;
        int id = Integer.parseInt(shortUrl.substring(index));
        return database.get(id);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));