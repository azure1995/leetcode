class Solution {
    public double helper(int poured, int query_row, int query_glass, double[][] rec) {
        if (query_glass < 0 || query_glass > query_row) {
            return 0.0;
        } else if (rec[query_row][query_glass] >= 0.0) {
            return rec[query_row][query_glass];
        }
        double upLeft = helper(poured, query_row - 1, query_glass - 1, rec) - 1.0;
        double upright = helper(poured, query_row - 1, query_glass, rec) - 1.0;
        rec[query_row][query_glass] = Math.max(upLeft, 0.0) / 2.0 + Math.max(upright, 0.0) / 2.0;
        return rec[query_row][query_glass];
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] rec = new double[query_row+1][];
        for (int i = 0; i <= query_row; i++) {
            rec[i] = new double[i+1];
            Arrays.fill(rec[i], -1.0);
        }
        rec[0][0] = (double)poured;
        return Math.min(1.0, helper(poured, query_row, query_glass, rec));
    }
}