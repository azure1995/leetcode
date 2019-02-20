class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int[] rec = new int[2001];
        int max = 0;
        for (int i = 0; i < fronts.length; i++) {
            max = Math.max(max, Math.max(fronts[i], backs[i]));
            if (fronts[i] == backs[i]) {
                rec[fronts[i]] = -1;
            } else {
                if (rec[fronts[i]] == 0) {
                    rec[fronts[i]] = 1;
                }
                if (rec[backs[i]] == 0) {
                    rec[backs[i]] = 1;
                }
            }
        }
        for (int i = 1; i <= max; i++) {
            if (rec[i] == 1) {
                return i;
            }
        }
        return 0;
    }
}
