class Solution {
    public boolean dfs(int p, Map<Integer, List<Integer>> map, Set<Integer>[] sets, int part) {
        for (int op : map.get(p)) {
            if (sets[part].contains(op)) {
                return false;
            }
        }
        for (int op : map.get(p)) {
            if (!sets[1 ^ part].contains(op)) {
                sets[1 ^ part].add(op);
                if (!dfs(op, map, sets, 1 ^ part)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Set<Integer>[] sets = new Set[2];
        sets[0] = new HashSet<>();
        sets[1] = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            if (!map.containsKey(dislikes[i][0])) {
                map.put(dislikes[i][0], new ArrayList<>());
            }
            map.get(dislikes[i][0]).add(dislikes[i][1]);
            if (!map.containsKey(dislikes[i][1])) {
                map.put(dislikes[i][1], new ArrayList<>());
            }
            map.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        for (int p : map.keySet()) {
            if (!sets[0].contains(p) && !sets[1].contains(p)) {
                sets[0].add(p);
                if (!dfs(p, map, sets, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
