class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int N = B.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(B[i])) {
                map.put(B[i], new LinkedList<>());
            }
            map.get(B[i]).add(i);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int left = 0, right = N - 1;
        int[] ret = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            if (A[right] > B[i]) {
                ret[map.get(B[i]).remove(0)] = A[right];
                right--;
            } else {
                ret[map.get(B[i]).remove(0)] = A[left];
                left++;
            }
        }
        return ret;
    }
}
