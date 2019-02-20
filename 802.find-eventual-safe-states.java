class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> terminals = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                terminals.add(i);
                continue;
            }
            for (int j = 0; j < graph[i].length; j++) {
                if (!map.containsKey(graph[i][j])) {
                    map.put(graph[i][j], new ArrayList<>());
                }
                map.get(graph[i][j]).add(i);
            }
        }
        int[] calc = new int[graph.length];
        for (int i = 0; i < terminals.size(); i++) {
            if (!map.containsKey(terminals.get(i))) continue;
            for (Integer from : map.get(terminals.get(i))) {
                calc[from]++;
                if (calc[from] == graph[from].length) {
                    terminals.add(from);
                }
            }
        }
        Collections.sort(terminals);
        return terminals;
    }
}