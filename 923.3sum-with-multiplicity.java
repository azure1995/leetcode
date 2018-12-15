class Solution {
    public int threeSumMulti(int[] A, int target) {
        int ret = 0, mod = (int) 1e9 + 7;
        int max2Sum = 2 * Arrays.stream(A).max().getAsInt();
        int[] sum2 = new int[max2Sum + 1];
        int[] record = new int[max2Sum + 1];
        sum2[A[0] + A[1]] = 1;
        record[A[0] + A[1]] = 1;
        for (int i = 2, pre = 1; i < A.length; i++) {
            if (A[i] > target)
                continue;
            if (A[i] + max2Sum >= target) {
                ret = (ret + record[target - A[i]]) % mod;
            }
            int[] tmp = new int[max2Sum + 1];
            int diff = A[i] - A[pre];
            for (int s = 0; s <= max2Sum; s++) {
                if (s - diff >= 0 && s - diff <= max2Sum) {
                    tmp[s] = sum2[s - diff];
                    record[s] = (record[s] + tmp[s]) % mod;
                }
            }
            tmp[A[i] + A[pre]]++;
            record[A[i] + A[pre]]++;
            pre = i;
            sum2 = tmp;
        }
        return ret;
    }
}
