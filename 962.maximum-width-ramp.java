class Solution {
    private int binarySearch(int arr[], int from, int to, int key) {
        while (from < to) {
            int mid = from + (to - from) / 2;
            if (arr[mid] <= key) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }
        return from;
    }

    public int maxWidthRamp(int[] A) {
        int N = A.length;
        int[] minArray = new int[A.length];
        for (int i = 0; i < N; i++) {
            minArray[i] = i == 0 ? A[0] : Math.min(A[i], minArray[i - 1]);
        }
        int ret = 0;
        for (int i = N - 1; i >= 1; i--) {
            int index = binarySearch(minArray, 0, i, A[i]);
            ret = Math.max(ret, i - index);
        }
        return ret;
    }
}