class Solution {
    public String minWindow(String s, String t) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ret = "";
        int counter = map.size();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                queue.offer(i);
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    counter--;
                }
                while (!queue.isEmpty() && map.get(s.charAt(queue.peek())) < 0) {
                    char c = s.charAt(queue.poll());
                    map.put(c, map.get(c) + 1);
                }
                if (counter == 0) {
                    String cand = s.substring(queue.peek(), i + 1);
                    ret = ret.length() == 0 || ret.length() > cand.length() ? cand : ret;
                }
            }
        }
        return ret;
    }
}
