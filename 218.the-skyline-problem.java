class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        return helper(buildings, 0, buildings.length - 1);
    }

    private List<int[]> helper(int[][] buildings, int lo, int hi) {
        List<int[]> ret = new ArrayList<>();
        if (lo > hi) {
            return ret;
        } else if (lo == hi) {
            ret.add(new int[] { buildings[lo][0], buildings[lo][2] });
            ret.add(new int[] { buildings[lo][1], 0 });
            return ret;
        }
        int mid = lo + (hi - lo) / 2;
        List<int[]> left = helper(buildings, lo, mid);
        List<int[]> right = helper(buildings, mid + 1, hi);
        int li = 0, ri = 0, hl = 0, hr = 0;
        while (li < left.size() || ri < right.size()) {
            long xl = li == left.size() ? Long.MAX_VALUE : left.get(li)[0];
            long xr = ri == right.size() ? Long.MAX_VALUE : right.get(ri)[0];
            if (xl <= xr) {
                hl = left.get(li)[1];
                li++;
            }
            if (xl >= xr) {
                hr = right.get(ri)[1];
                ri++;
            }
            int x = (int) Math.min(xl, xr);
            int h = Math.max(hl, hr);
            if (ret.isEmpty() || ret.get(ret.size() - 1)[1] != h) {
                ret.add(new int[] { x, h });
            }
        }
        return ret;
    }
}