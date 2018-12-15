class Solution {
    public void dfs(int[][] stones, boolean[] visited, int center) {
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && (stones[i][0] == stones[center][0] || stones[i][1] == stones[center][1])) {
                visited[i] = true;
                dfs(stones, visited, i);
            }
        }
    }

    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        int notRemove = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                notRemove++;
                visited[i] = true;
                dfs(stones, visited, i);
            }
        }
        return stones.length - notRemove;
    }
}