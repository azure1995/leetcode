class Solution {
    public int get(int[] piles, int k) {
        int ret = 0;
        for (int pile : piles) {
            ret += pile % k == 0 ? pile / k : pile / k + 1;
        }
        return ret;
    }

    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, h = Arrays.stream(piles).max().getAsInt();
        while (l <= h) {
            int mid = (l + h) / 2;
            if (get(piles, mid) <= H) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h + 1;
    }
}