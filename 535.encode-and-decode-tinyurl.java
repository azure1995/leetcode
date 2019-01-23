public class Codec {
    int globalCounter = 0;
    List<String> list = new ArrayList<>();
    char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public int idAllocator() {
        return globalCounter++;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int id = idAllocator();
        StringBuilder sb = new StringBuilder();
        int temp = id;
        while (temp > 0) {
            sb.append(map[temp % 62]);
            temp /= 62;
        }
        list.add(longUrl);
        return sb.reverse().toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int id = 0;
        for (int i = 0; i < shortUrl.length(); i++) {
            id *= 62;
            if ('a' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'z')
                id += shortUrl.charAt(i) - 'a';
            if ('A' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'Z')
                id += shortUrl.charAt(i) - 'A' + 26;
            if ('0' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= '9')
                id += shortUrl.charAt(i) - '0' + 52;
        }
        return list.get(id);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));