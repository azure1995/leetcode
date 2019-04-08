class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], p = edge[2];
            map.computeIfAbsent(from, x -> new HashMap<>()).put(to, p + 1);
            map.computeIfAbsent(to, x -> new HashMap<>()).put(from, p + 1);
        }
        map.computeIfAbsent(-1, x -> new HashMap<>()).put(0, 1);
        if (!map.containsKey(0)) {
            return 1;
        }
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { 0, 0, -1 });
        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        Set<String> set = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] head = pq.poll();
            int node = head[0], d = head[1], from = head[2];
            if (dist[node] != -1)
                continue;
            dist[node] = d;
            set.add(from + " " + node);
            ans += map.get(from).get(node);
            for (int next : map.get(node).keySet()) {
                int len = map.get(node).get(next);
                if (dist[next] == -1 && len + d <= M) {
                    if (len + d < M) {
                        pq.offer(new int[] { next, len + d, node });
                    }
                }
            }
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], p = edge[2];
            if (set.contains(from + " " + to) || set.contains(to + " " + from))
                continue;
            if (dist[from] == -1 && dist[to] == -1)
                continue;
            if (dist[from] == -1 || dist[to] == -1) {
                ans += M - Math.max(dist[from], dist[to]);
            } else {
                ans += Math.min(p, 2 * M - dist[from] - dist[to]);
            }
        }
        return ans;
    }
}