class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A == E && B == F && C == G && D == H) {
            return (C - A) * (D - B);
        }
        int[][][] twoRects = new int[2][][];
        int firstIndex = A <= E ? 0 : 1;
        twoRects[firstIndex] = new int[][] { { A, B }, { C, D } };
        twoRects[firstIndex ^ 1] = new int[][] { { E, F }, { G, H } };
        if (twoRects[1][0][0] >= twoRects[0][1][0]) {
            return (C - A) * (D - B) + (G - E) * (H - F);
        } else {
            int notOverlapedArea = (twoRects[1][0][0] - twoRects[0][0][0]) * (twoRects[0][1][1] - twoRects[0][0][1]);
            if (twoRects[1][1][0]>twoRects[0][1][0]) {
                notOverlapedArea+=(twoRects[1][1][0] - twoRects[0][1][0])*(twoRects[1][1][1] - twoRects[1][0][1]);
            } else {
                notOverlapedArea+=(twoRects[0][1][0]-twoRects[1][1][0])*(twoRects[0][1][1]-twoRects[0][0][1]);
            }
            int rightSide = Math.min(twoRects[0][1][0], twoRects[1][1][0]);
            int overlapedArea = computeArea(twoRects[0][0][1], twoRects[1][0][0], twoRects[0][1][1], rightSide,
                    twoRects[1][0][1], twoRects[1][0][0], twoRects[1][1][1], rightSide);
            return notOverlapedArea + overlapedArea;
        }
    }
}
