class Solution {
    final int[][] directs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        int counter = 0;
        int cur_r = r0, cur_c = c0;
        int time = 0;
        while (counter < R * C) {
            int dist = time / 2 + 1;
            for (int i = 0; i < dist; i++) {
                if (cur_r >= 0 && cur_r < R && cur_c >= 0 && cur_c < C) {
                    ret[counter++] = new int[] { cur_r, cur_c };
                }
                cur_r += directs[time % 4][0];
                cur_c += directs[time % 4][1];
            }
            time++;
        }
        return ret;
    }
}