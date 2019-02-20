class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int globalMax = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int x1 = points[i].x, y1 = points[i].y;
            int dup = 1, localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int dx = x1 - points[j].x, dy = y1 - points[j].y;
                if (dx == 0 && dy == 0) {
                    dup++;
                    continue;
                } else {
                    int gcd = getGCD(dy, dx);
                    dx /= gcd;
                    dy /= gcd;
                    if (!map.containsKey(dx)) {
                        map.put(dx, new HashMap<>());
                    }
                    Map<Integer, Integer> bMap = map.get(dx);
                    bMap.put(dy, bMap.getOrDefault(dy, 0) + 1);
                    localMax = Math.max(localMax, bMap.get(dy));
                }
            }
            globalMax = Math.max(globalMax, localMax + dup);
        }
        return globalMax;
    }
    
    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a%b);
    }
}