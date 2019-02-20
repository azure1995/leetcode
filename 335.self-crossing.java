class Solution {
    public boolean isSelfCrossing(int[] x) {
        boolean open = true;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) return true;
            if (i < 2) continue;
            if (open && x[i] > x[i - 2]) continue;
            if (open) {
                if (i + 1 == x.length) return false;
                if (x[i] >= x[i - 2] - (i < 4 ? 0 : x[i - 4]) && x[i + 1] >= x[i - 1] - (i < 3 ? 0 : x[i - 3])) {
                    return true;
                } 
                open = false;
                continue;
            }
            if (!open && x[i] < x[i - 2]) continue;
            return true;
        }
        return false;
    }
}