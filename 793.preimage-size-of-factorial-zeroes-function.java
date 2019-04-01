class Solution {
    public int preimageSizeFZF(int K) {
        long l = 0, h = (long) Math.pow(5, (int) (Math.log(4l * K + 1) / Math.log(5)) + 1);
        while (l <= h) {
            long mid = (h - l) / 2 + l;
            long c = count(mid);
            if (c > K) {
                h = mid - 1;
            } else if (c == K) {
                return 5;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }

    private long count(long num) {
        long ans = 0;
        while (num > 0) {
            ans += num / 5;
            num /= 5;
        }
        return ans;
    }
}
