class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int s : routes[i]) {
                if (!map.containsKey(s)) {
                    map.put(s, new ArrayList<>());
                }
                map.get(s).add(i);
            }
        }
        Set<Integer> vr = new HashSet<>();
        Set<Integer> vs = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(S);
        vs.add(S);
        int ans = 0;
        while (!cur.isEmpty()) {
            ans++;
            List<Integer> next = new ArrayList<>();
            for (int s : cur) {
                for (int r : map.get(s)) {
                    if (!vr.contains(r)) {
                        vr.add(r);
                        for (int ns : routes[r]) {
                            if (!vs.contains(ns)) {
                                if (ns == T) {
                                    return ans;
                                }
                                vs.add(ns);
                                next.add(ns);
                            }
                        }
                    }
                }
            }
            cur = next;
        }
        return -1;
    }
}
