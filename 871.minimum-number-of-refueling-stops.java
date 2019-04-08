class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int gas = startFuel, dist = 0, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < stations.length; i++) {
            if (gas + dist >= target) break;
            int st = i - 1;
            while (i < stations.length && gas >= stations[i][0] - (st == -1 ? 0 : stations[st][0])) {
                pq.offer(stations[i][1]);
                i++;
            }
            i--;
            gas -= ((i == -1 ? 0 : stations[i][0]) - (st == -1 ? 0 : stations[st][0]));
            dist = i == -1 ? 0 : stations[i][0];
            if (pq.isEmpty()) break;
            gas += pq.poll();
            ans++;
        }
        while (!pq.isEmpty() && gas + dist < target) {
            gas += pq.poll();
            ans++;
        }
        return gas + dist >= target ? ans : -1;
    }
}
