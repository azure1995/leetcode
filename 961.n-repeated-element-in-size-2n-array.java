class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) == 2) {
                return A[i];
            }
        }
        for (int i = 4; i < A.length - 1; i += 2) {
            if (A[i] == A[i + 1]) {
                return A[i];
            }
        }
        throw null;
    }
}
