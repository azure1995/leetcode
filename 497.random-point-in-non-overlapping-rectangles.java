class Solution {
    Random rand;
    int[][] rects;
    int[] areaSums;

    public int getPoints(int[] corners) {
        return (corners[2] - corners[0] + 1) * (corners[3] - corners[1] + 1);
    }

    public Solution(int[][] rects) {
        rand = new Random();
        this.rects = rects;
        areaSums = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            areaSums[i] = i == 0 ? getPoints(rects[i]) : areaSums[i - 1] + getPoints(rects[i]);
        }
    }

    public int[] pick() {
        int p = rand.nextInt(areaSums[areaSums.length - 1]);
        int pickedRect = 0;
        while (pickedRect < areaSums.length) {
            if (p < areaSums[pickedRect]) {
                break;
            }
            pickedRect++;
        }
        int width = rects[pickedRect][2] - rects[pickedRect][0];
        int height = rects[pickedRect][3] - rects[pickedRect][1];
        int x = rects[pickedRect][0] + rand.nextInt(width + 1);
        int y = rects[pickedRect][1] + rand.nextInt(height + 1);
        return new int[] { x, y };
    }
}