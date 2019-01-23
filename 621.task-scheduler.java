public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, slots = (map[25] - 1) * n;
        for (int i = 24; i >= 0; i--) {
            if (map[i] == 0) {
                break;
            }
            slots -= Math.min(map[i], max_val);
            if (slots < 0) {
                return tasks.length;
            }
        }
        return slots + tasks.length;
    }
}