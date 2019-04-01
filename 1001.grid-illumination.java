class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1, 0};
        int[] dx = {0, -1, 0, 1, 1, 1, 0, -1, -1};
        Map<Integer, Integer> horizontal = new HashMap<>();
        Map<Integer, Integer> vertical = new HashMap<>();
        Map<Integer, Integer> diagonal1 = new HashMap<>();
        Map<Integer, Integer> diagonal2 = new HashMap<>();
        Set<String> lampSet = new HashSet<>();
        for (int[] lamp : lamps) {
            int y = lamp[0], x = lamp[1];
            lampSet.add(y + "," + x);
            horizontal.put(y ,horizontal.getOrDefault(y, 0) + 1);
            vertical.put(x, vertical.getOrDefault(x, 0) + 1);
            diagonal1.put(y - x, diagonal1.getOrDefault(y - x, 0) + 1);
            diagonal2.put(y + x, diagonal2.getOrDefault(y + x, 0) + 1);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int y = queries[i][0], x = queries[i][1];
            if (horizontal.getOrDefault(y, 0) > 0 || vertical.getOrDefault(x, 0) > 0
               || diagonal1.getOrDefault(y - x, 0) > 0 || diagonal2.getOrDefault(y + x, 0) > 0) {
                res[i] = 1;
            }
            for (int d = 0; d < 9; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx <= N && lampSet.contains(ny + "," + nx)) {
                    lampSet.remove(ny + "," + nx);
                    horizontal.put(ny, horizontal.get(ny) - 1);
                    vertical.put(nx, vertical.get(nx) - 1);
                    diagonal1.put(ny - nx, diagonal1.get(ny - nx) - 1);
                    diagonal2.put(ny + nx, diagonal2.get(ny + nx) - 1);
                }
            }
        }
        return res;
    }
}