class Solution {
    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.containsKey(0) && map.get(0) % 2 == 1) {
            return false;
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) == 0 || num == 0) {
                continue;
            }
            if (num < 0) {
                if (num % 2 == 1 || !map.containsKey(num / 2) || map.get(num / 2) < map.get(num)) {
                    return false;
                }
                map.put(num / 2, map.get(num / 2) - map.get(num));
            } else {
                if (!map.containsKey(num * 2) || map.get(num * 2) < map.get(num)) {
                    return false;
                }
                map.put(num * 2, map.get(num * 2) - map.get(num));
            }
        }
        return true;
    }
}