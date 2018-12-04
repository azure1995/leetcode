class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W > 0) {
            return false;
        }
        if (W == 1) {
            return true;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        int[] rec = new int[W - 1];
        int cur = 0;
        int pre = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (rec[cur] == 0) {
                Arrays.fill(rec, entry.getValue());
                pre = entry.getKey();
            } else {
                int count = rec[cur];
                if (entry.getKey() != pre + 1 || entry.getValue() < count) {
                    return false;
                }
                rec[cur] = 0;
                if (entry.getValue() > count) {
                    for (int i = 0; i < W - 1; i++) {
                        rec[i] += entry.getValue() - count;
                    }
                }
                pre++;
                cur = (cur + 1) % (W - 1);
            }
        }
        return rec[cur] == 0;
    }
}