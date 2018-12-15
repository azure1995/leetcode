class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
            map.get(x).add(y);
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    ret = Math.min(ret, Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1])));
                }
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}
