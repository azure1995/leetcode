class Solution {
    public int reversePairs(int[] nums) {
        return mergesort_count(nums, 0, nums.length);
    }

    private void merge(int[] A, int from, int mid, int to) {
        int[] left = Arrays.copyOfRange(A, from, mid);
        int[] right = Arrays.copyOfRange(A, mid, to);
        for (int i = from, il = 0, ir = 0; i < to; i++) {
            if (ir == right.length || il < left.length && left[il] < right[ir]) {
                A[i] = left[il++];
            } else {
                A[i] = right[ir++];
            }
        }
    }

    private int mergesort_count(int[] A, int from, int to) {
        if (to - from <= 1) {
            return 0;
        }
        int mid = (from + to) / 2;
        int ret = mergesort_count(A, from, mid) + mergesort_count(A, mid, to);
        int j = mid;
        for (int i = from; i < mid; i++) {
            while (j < to && A[i] > 2l * A[j]) {
                j++;
            }
            ret += j - mid;
        }
        merge(A, from, mid, to);
        return ret;
    }
}