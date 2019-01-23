class Solution {
    public int findRotateSteps(String ring, String key) {
        int len = ring.length();
        Map<Integer, Integer> cur = new HashMap<>();
        cur.put(0, 0);
        for (char ch : key.toCharArray()) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Integer p : cur.keySet()) {
                for (int i = 0; i < len; i++) {
                    if (ring.charAt(i) == ch) {
                        int sp = Math.min(Math.abs(p - i), Math.min(len + p - i, len - p + i));
                        next.put(i, Math.min(cur.get(p) + sp, next.getOrDefault(i, Integer.MAX_VALUE)));
                    }
                }
            }
            cur = next;
        }
        return Collections.min(cur.values()) + key.length();
    }
}