class OrderedStream {
    // 存储键值对的数组
    String[] storage = null;
    // ptr指针
    int ptr = 1;
    public OrderedStream(int n) {
        // 对数组进行初始化。
        storage = new String[n + 1];
    }
    
    public List<String> insert(int idKey, String value) {
        storage[idKey] = value;

        // 存储返回值
        List<String> ans = new ArrayList<>();

        // 检查ptr是否等于idKey
        while (ptr < storage.length && storage[ptr] != null) {
            ans.add(storage[ptr++]);
        }

        return ans;
    }
}
