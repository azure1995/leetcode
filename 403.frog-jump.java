class Solution {
    public boolean canCross(int[] stones) {
        int dest = stones[stones.length - 1];
        Set<Integer> set = new HashSet<>();
        Set<String> memo = new HashSet<>();
        for (int s : stones) {
            set.add(s);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 1 });
        memo.add("0#1");
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int d = head[0] + head[1], p = head[1];
            if (!set.contains(d)) {
                continue;
            } else if (d == dest) {
                return true;
            }
            for (int k = p - 1; k <= p + 1; k++) {
                if (k <= 0) {
                    continue;
                }
                if (!memo.contains(d + "#" + k)) {
                    queue.offer(new int[] { d, k });
                    memo.add(d + "#" + k);
                }
            }
        }
        return false;
    }
}