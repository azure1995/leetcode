class Solution {

    private int findRoot(int p, int[] roots) {
        int r = p;
        while (roots[r] != r) {
            r = roots[r];
        }
        while (p != r) {
            int tmp = roots[p];
            roots[p] = r;
            p = tmp;
        }
        return r;
    }

    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        int[] coaches = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            coaches[row[i]] = i / 2;
        }
        int[] roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
        int[] sizes = new int[N];
        Arrays.fill(sizes, 1);
        for (int i = 0; i < N; i++) {
            int p1 = 2 * i, p2 = 2 * i + 1;
            if (coaches[p1] != coaches[p2]) {
                int r1 = findRoot(coaches[p1], roots), r2 = findRoot(coaches[p2], roots);
                if (r1 != r2) {
                    roots[r2] = r1;
                    sizes[r1] += sizes[r2];
                    sizes[r2] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (sizes[i] > 0) {
                ans += sizes[i] - 1;
            }
        }
        return ans;
    }
}
