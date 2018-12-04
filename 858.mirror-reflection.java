class Solution {
    public int helper(int[] corner, int p, int q, int st) {
        int dist = p - st;
        if (dist % q == 0) {
            return corner[(dist / q) % 2];
        } else {
            int next_st = q - (dist % q);
            int next_dist = p - next_st;
            if (next_dist % q == 0) {
                return 0;
            }
            if (((dist / q % 2) ^ (next_dist / q % 2)) == 0) {
                return helper(corner, p, q, q - (next_dist % q));
            } else {
                return helper(new int[] { corner[1], corner[0] }, p, q, q - (next_dist % q));
            }
        }
    }

    public int mirrorReflection(int p, int q) {
        return helper(new int[] { 1, 2 }, p, q, q);
    }
}