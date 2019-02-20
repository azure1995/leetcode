class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        int k = 0, pos = 0, neg = 0;
        while (target > 0) {
            int cur = target % x;
            target /= x;
            if (k > 0) {
                int pos2 = Math.min(pos + k * cur, neg + k * (cur + 1));
                int neg2 = Math.min(pos + k * (x - cur), neg + k * (x - cur - 1));
                pos = pos2;
                neg = neg2;
            } else {
                pos = 2 * cur;
                neg = 2 * (x - cur);
            }
            k++;
        }
        return Math.min(pos, neg + k) - 1;
    }
}
