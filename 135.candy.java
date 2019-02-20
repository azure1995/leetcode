class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] left = new int[N];
        int[] right = new int[N];
        for (int i = 1; i < N; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 0;
        }
        for (int i = N - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 0;
        }
        int ret = N;
        for (int i = 0; i < N; i++) {
            ret += Math.max(left[i], right[i]);
        }
        return ret;
    }
}