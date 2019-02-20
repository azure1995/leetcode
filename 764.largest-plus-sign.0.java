class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (mines.length == 0) {
            return (N + 1) / 2;
        }
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 1);
        }
        for (int i = 0; i < mines.length; i++) {
            map[mines[i][0]][mines[i][1]] = 0;
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    continue;
                }
                map[i][j] = ++count;
            }
            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] == 0) {
                    count = 0;
                    continue;
                }
                map[i][j] = Math.min(map[i][j], ++count);
            }
        }
        int ret = 0;
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 0) {
                    count = 0;
                    continue;
                }
                map[i][j] = Math.min(map[i][j], ++count);
            }
            count = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] == 0) {
                    count = 0;
                    continue;
                }
                map[i][j] = Math.min(map[i][j], ++count);
                ret = Math.max(ret, map[i][j]);
            }
        }
        return ret;
    }
}