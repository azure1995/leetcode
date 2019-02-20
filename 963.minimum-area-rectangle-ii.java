class Solution {

    public double minAreaFreeRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] * 40000 + p[1]);
        }
        double ret = 0;
        for (int p1 = 0; p1 < points.length - 2; p1++) {
            int x1 = points[p1][0], y1 = points[p1][1];
            for (int p2 = p1 + 1; p2 < points.length - 1; p2++) {
                int x2 = points[p2][0], y2 = points[p2][1];
                for (int p3 = p2 + 1; p3 < points.length; p3++) {
                    int x3 = points[p3][0], y3 = points[p3][1];
                    int[][] threePoints = { { x1, y1 }, { x2, y2 }, { x3, y3 } };
                    int[][] v = new int[][] { { x3 - x1, y3 - y1 }, { x2 - x1, y2 - y1 }, { x3 - x2, y3 - y2 } };
                    for (int k = 0; k < 3; k++) {
                        if (v[k][0] * v[(k + 1) % 3][0] + v[k][1] * v[(k + 1) % 3][1] == 0) {
                            int[] corner = threePoints[k];
                            int[] four = { threePoints[(k + 1) % 3][0] + threePoints[(k + 2) % 3][0] - corner[0],
                                    threePoints[(k + 1) % 3][1] + threePoints[(k + 2) % 3][1] - corner[1] };
                            if (set.contains(four[0] * 40000 + four[1])) {
                                double area = Math.abs(v[(k + 1) % 3][0] * v[(k + 2) % 3][1]
                                        - v[(k + 1) % 3][1] * v[(k + 2) % 3][0]);
                                ret = ret == 0 ? area : Math.min(ret, area);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }
}