import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (String s : helper(i, N, K)) {
                ret.add(Integer.valueOf(s));
            }
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }

    private List<String> helper(int start, int n, int K) {
        if (start < 0 || start > 9) {
            return Collections.EMPTY_LIST;
        } else if (n == 1) {
            return Collections.singletonList("" + start);
        }
        List<String> post = helper(start + K, n - 1, K);
        if (K != 0) {
            post.addAll(helper(start - K, n - 1, K));
        }
        List<String> ret = new ArrayList<>();
        for (String s : post) {
            ret.add(start + s);
        }
        return ret;
    }
}