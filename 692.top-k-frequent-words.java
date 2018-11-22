class Solution {
    Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            if (e1.getValue() != e2.getValue()) {
                return e1.getValue().compareTo(e2.getValue());
            } else {
                return -e1.getKey().compareTo(e2.getKey());
            }
        }
    };

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comp);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        List<String> ret = new LinkedList<>();
        while (!pq.isEmpty()) {
            ret.add(0, pq.remove().getKey());
        }
        return ret;
    }
}
