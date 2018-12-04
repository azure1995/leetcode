class Solution {
    public boolean dfs(int node, int[][] graph, Set<Integer>[] sets, int part) {
        for (int i = 0; i < graph[node].length; i++) {
            if (sets[part].contains(graph[node][i])) {
                return false;
            }
        }
        for (int i = 0; i < graph[node].length; i++) {
            int nb = graph[node][i];
            if (!sets[1 ^ part].contains(nb)) {
                sets[1 ^ part].add(nb);
                if (!dfs(nb, graph, sets, 1 ^ part)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Set<Integer>[] sets = new Set[2];
        sets[0] = new HashSet<>();
        sets[1] = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (!sets[0].contains(i) && !sets[1].contains(i)) {
                sets[0].add(i);
                if (!dfs(i, graph, sets, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
