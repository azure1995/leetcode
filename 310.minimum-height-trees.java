class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Integer p = map.get(leaf).iterator().next();
                if (n == 1) {
                    return Collections.singletonList(p);
                }
                map.get(p).remove(leaf);
                if (map.get(p).size() == 1) {
                    newLeaves.add(p);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }
};