class Solution {
    public int inner(int[] v1, int[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1];
    }

    public int square (int[] v) {
        return v[0]*v[0] + v[1]*v[1];
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] v = { {p1[0] - p4[0], p1[1] - p4[1]}, { p2[0] - p4[0], p2[1] - p4[1] },
                { p3[0] - p4[0], p3[1] - p4[1] } };
        boolean possible = false;
        for (int i = 0; i < 3; i++) {
            if (inner(v[(i + 2) % 3], v[i]) != 0 && inner(v[i], v[(i + 1) % 3]) != 0) {
                possible = true;
                if (i < 2) {
                    int[] temp = v[2];
                    v[2] = v[i];
                    v[i] = temp;
                }
            }
        }
        if (!possible || inner(v[0], v[1]) != 0) {
            return false;
        }
        int[][] vv = { v[0], { v[2][0] - v[0][0], v[2][1] - v[0][1] }, { v[1][0] - v[2][0], v[1][1] - v[2][1] },
                { -v[1][0], -v[1][1] } };
        for (int i = 0; i < 3; i++) {
            if (inner(vv[i], vv[i + 1]) != 0 || square(vv[i])!=square(vv[i+1])) {
                return false;
            }
        }
        return true;
    }
}