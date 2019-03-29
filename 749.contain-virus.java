class Solution {
    int num = 0;

    public int containVirus(int[][] grid) {
        int[][] nsWalls = new int[grid.length + 1][grid[0].length];
        int[][] weWalls = new int[grid.length][grid[0].length + 1];
        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                count += cell;
            }
        }
        Set<Integer> prot = new HashSet<>();
        helper(grid, nsWalls, weWalls, count, prot);
        return num;
    }

    private void helper(int[][] grid, int[][] nsWalls, int[][] weWalls, int count, Set<Integer> prot) {
        // System.out.println(num);
        int R = grid.length, C = grid[0].length;
        if (count == R * C) {
            return;
        }
        int[][] visited = new int[R][C];
        int max = 0;
        List<Set<Integer>> lists = new ArrayList<>();
        List<Integer> maxNs = new ArrayList<>();
        List<Integer> maxWe = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!prot.contains(i * C + j) && grid[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    Set<Integer> list = new HashSet<>();
                    List<Integer> newNs = new ArrayList<>();
                    List<Integer> newWe = new ArrayList<>();
                    dfs(grid, visited, nsWalls, weWalls, i, j, list, newNs, newWe);
                    if (max < list.size()) {
                        max = list.size();
                        maxNs.clear();
                        maxNs.addAll(newNs);
                        maxWe.clear();
                        maxWe.addAll(newWe);
                    }
                    if (list.size() > 0) {
                        // System.out.println(list.size());
                        lists.add(list);
                    }
                }
            }
        }
        if (lists.size() == 0) {
            return;
        }
        for (Set<Integer> list : lists) {
            if (list.size() == max) {
                prot.addAll(list);
                continue;
            }
            for (int p : list) {
                int r = p / C, c = p % C;
                if (grid[r][c] == 0) {
                    grid[r][c] = 1;
                    count++;
                }
            }
        }
        num += maxNs.size();
        // System.out.println(maxNs.size());
        for (int w : maxNs) {
            nsWalls[w / C][w % C] = 1;
        }
        num += maxWe.size();
        // System.out.println(maxWe.size());
        for (int w : maxWe) {
            weWalls[w / (C + 1)][w % (C + 1)] = 1;
        }
        helper(grid, nsWalls, weWalls, count, prot);
    }

    private void dfs(int[][] grid, int[][] visited, int[][] nsWalls, int[][] weWalls, int r, int c, Set<Integer> list,
            List<Integer> newNs, List<Integer> newWe) {
        int[][] di = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int R = grid.length, C = grid[0].length;
        for (int d = 0; d < 4; d++) {
            if ((d == 0 && nsWalls[r][c] == 1) || (d == 1 && nsWalls[r + 1][c] == 1) || (d == 2 && weWalls[r][c] == 1)
                    || (d == 3 && weWalls[r][c + 1] == 1)) {
                continue;
            }
            int nr = r + di[d][0], nc = c + di[d][1];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    dfs(grid, visited, nsWalls, weWalls, nr, nc, list, newNs, newWe);
                } else if (grid[nr][nc] == 0) {
                    list.add(nr * C + nc);
                    if (d == 0) {
                        newNs.add(r * C + c);
                    } else if (d == 1) {
                        newNs.add((r + 1) * C + c);
                    } else if (d == 2) {
                        newWe.add(r * (C + 1) + c);
                    } else {
                        newWe.add(r * (C + 1) + c + 1);
                    }
                }
            }
        }
    }
}
