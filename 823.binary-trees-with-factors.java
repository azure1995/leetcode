class Solution {
    final int mod = (int) (1e9) + 7;

    public int numFactoredBinaryTrees(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], 1);
        }
        Arrays.sort(A);
        int ret = A.length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (A[j] > A[A.length - 1] / A[i]) break;
                if (map.containsKey(A[i] * A[j])) {
                    int add = (int)(((i == j ? 1l : 2l) * map.get(A[i]) * map.get(A[j])) % mod);
                    map.put(A[i] * A[j], (map.get(A[i] * A[j]) + add) % mod);
                    ret = (ret + add) % mod;
                }
            }
        }
        return ret;
    }
}
