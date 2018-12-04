class Solution {
    public int minSwap(int[] A, int[] B) {
        int base = 0, cur = 0, swaps = 0, counter = 1;
        for (int i = 1; i < A.length; i++) {
            if (Math.min(A[i], B[i]) > Math.max(A[i - 1], B[i - 1])) {
                base = cur;
                swaps = 0;
                counter = 1;
            } else {
                counter++;
                if (A[i] <= A[i - 1] || B[i] <= B[i - 1]) {
                    swaps++;
                    if (swaps > counter - swaps) {
                        swaps = counter - swaps;
                    } else {
                        int tmp = A[i];
                        A[i] = B[i];
                        B[i] = tmp;
                    }
                }
                cur = base + swaps;
            }
        }
        return cur;
    }
}