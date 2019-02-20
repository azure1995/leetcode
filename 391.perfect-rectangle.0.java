class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int x0 = rectangles[0][0], y0 = rectangles[0][1];
        int i = 0;
        while (i + 1 < rectangles.length && rectangles[i + 1][0] == x0) i++;
        int height = rectangles[i][3] - rectangles[0][1];
        int[] base = new int[height];
        for (int[] rect : rectangles) {
            rect[0] -= x0;
            rect[1] -= y0;
            rect[2] -= x0;
            rect[3] -= y0;
            for (int h = rect[1]; h < rect[3]; h++) {
                if (h < 0 || h >= height || base[h] != rect[0]) {
                    return false;
                }
                base[h] = rect[2];
            }
        }
        for (int j = 1; j < height; j++) {
            if (base[j] != base[0]) {
                return false;
            }
        }
        return true;
    }
}