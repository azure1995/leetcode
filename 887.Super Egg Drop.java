class Solution {
    public int superEggDrop(int K, int N) {
        return helper(K, N, new HashMap<>());
    }

    public int helper(int k, int n, Map<Integer, Map<Integer, Integer>> memo) {
        if (memo.getOrDefault(k, new HashMap<>()).containsKey(n)) {
            return memo.get(k).get(n);
        }
        int ans = 0;
        if (n == 0) {
            ans = 0;
        } else if (k == 1) {
            ans = n;
        } else {
            ans = 1;
            int l = 0, h = n + 1;
            boolean found = false;
            while (l < h - 1) {
                int mid = (l + h) / 2;
                int res1 = helper(k, n - mid, memo), res2 = helper(k - 1, mid - 1, memo);
                if (res1 > res2) {
                    l = mid;
                } else if (res1 == res2) {
                    found = true;
                    ans += res1;
                    break;
                } else {
                    h = mid;
                }
            }
            if (!found) {
                ans += Math.max(helper(k, n - l, memo), helper(k - 1, h - 1, memo));
            }
        } 
        memo.computeIfAbsent(k, x -> new HashMap<>()).put(n, ans);
        return ans;
    }
}