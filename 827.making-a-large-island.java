class Solution {

    private int findRoot(int n, int[] rootArr) {
        int r = n;
        while (rootArr[r] != r) {
            r = rootArr[r];
        }
        while (n != r) {
            int tmp = rootArr[n];
            rootArr[n] = r;
            n = tmp;
        }
        return r;
    }

    public int largestIsland(int[][] grid) {
        int N = grid.length;
        int[] rootArr = new int[N * N];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int root = i * N + j, count = 1;
                    rootArr[root] = root;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        int root1 = findRoot((i - 1) * N + j, rootArr);
                        rootArr[root1] = root;
                        count += map.get(root1);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        int root2 = findRoot(i * N + j - 1, rootArr);
                        rootArr[root2] = root;
                        if (root2 != root)
                            count += map.get(root2);
                    }
                    map.put(root, count);
                    max = Math.max(max, count);
                }
            }
        }
        int[][] di = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int tmp = 1;
                    Set<Integer> roots = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ni = i + di[d][0], nj = j + di[d][1];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N && grid[ni][nj] == 1) {
                            int root = findRoot(ni * N + nj, rootArr);
                            if (roots.contains(root))
                                continue;
                            roots.add(root);
                            tmp += map.get(root);
                        }
                    }
                    max = Math.max(max, tmp);
                }
            }
        }
        return max;
    }
}