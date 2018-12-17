class Solution {
    private int getRoot(int c, int[] rootMap) {
        if (rootMap[c] == 0) {
            rootMap[c] = c;
            return c;
        }
        int root = c;
        while (root != rootMap[root]) {
            root = rootMap[root];
        }
        while (c != root) {
            int temp = rootMap[c];
            rootMap[c] = root;
            c = temp;
        }
        return root;
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int[] rootMap = new int[(N + 1) * (N + 1)];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || i == N || j == 0 || j == N) {
                    rootMap[i * (N + 1) + j] = 1;
                }
            }
        }
        int ret = 1;
        for (int i = 0; i < N; i++) {
            String line = grid[i];
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == ' ') {
                    continue;
                }
                int r1 = line.charAt(j) == '/' ? getRoot((i + 1) * (N + 1) + j, rootMap)
                        : getRoot((i + 1) * (N + 1) + j + 1, rootMap);
                int r2 = line.charAt(j) == '/' ? getRoot(i * (N + 1) + j + 1, rootMap)
                        : getRoot(i * (N + 1) + j, rootMap);
                if (r1 == r2) {
                    ret++;
                } else {
                    rootMap[r1] = r2;
                }
            }
        }
        return ret;
    }
}