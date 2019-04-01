class Solution {

    private int findRoot(int i, int j, int R, int C, int[][] code, List<Integer> roots) {
        if (i < 0 || i >= R || j < 0 || j >= C || code[i][j] == 0) {
            return 0;
        }
        int c = code[i][j], r = code[i][j];
        while (roots.get(r) != r) {
            r = roots.get(r);
        }
        while (c != r) {
            int tmp = roots.get(c);
            roots.set(c, r);
            c = tmp;
        }
        return r;
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] valid = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            if (grid[hits[i][0]][hits[i][1]] == 1) {
                valid[i] = 1;
                grid[hits[i][0]][hits[i][1]] = 0;
            }
        }
        int R = grid.length, C = grid[0].length;
        int[][] code = new int[R][C];
        int r = 1;
        List<Integer> count = new ArrayList<>();
        List<Integer> roots = new ArrayList<>();
        count.add(0);
        count.add(0);
        roots.add(0);
        roots.add(1);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1 && code[i][j] == 0) {
                    if (i > 0) {
                        r++;
                    }
                    code[i][j] = r;
                    if (r > 1) {
                        roots.add(r);
                        count.add(dfs(i, j, R, C, r, code, grid));
                    } else {
                        count.set(r, count.get(r) + dfs(i, j, R, C, r, code, grid));
                    }
                }
            }
        }
        int[] ans = new int[hits.length];
        for (int k = hits.length - 1; k >= 0; k--) {
            if (valid[k] == 0) {
                continue;
            }
            int i = hits[k][0], j = hits[k][1];
            Set<Integer> rs = new HashSet<>();
            rs.add(findRoot(i - 1, j, R, C, code, roots));
            rs.add(findRoot(i, j + 1, R, C, code, roots));
            rs.add(findRoot(i + 1, j, R, C, code, roots));
            rs.add(findRoot(i, j - 1, R, C, code, roots));
            int t = Integer.MAX_VALUE;
            if (i == 0) {
                code[i][j] = 1;
                t = 1;
            } else {
                for (int m : rs) {
                    if (m > 0) {
                        t = Math.min(t, m);
                    }
                }
            }
            if (t == Integer.MAX_VALUE) {
                r++;
                code[i][j] = r;
                roots.add(r);
                count.add(1);
            } else {
                int add = 0;
                code[i][j] = t;
                for (int m : rs) {
                    if (m > t) {
                        roots.set(m, t);
                        add += count.get(m);
                    }
                }
                count.set(t, add + 1 + count.get(t));
                if (t == 1) {
                    ans[k] = add;
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int R, int C, int r, int[][] code, int[][] grid) {
        int ans = 1;
        int[][] di = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int[] d : di) {
            int ni = i + d[0], nj = j + d[1];
            if (0 <= ni && ni < R && 0 <= nj && nj < C && grid[ni][nj] == 1 && code[ni][nj] == 0) {
                code[ni][nj] = r;
                ans += dfs(ni, nj, R, C, r, code, grid);
            }
        }
        return ans;
    }
}
