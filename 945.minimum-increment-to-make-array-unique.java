class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int reSum = 0, newSum = 0;
        for (int i = 1, reNum = 0; i <= A.length; i++) {
            while (i < A.length && A[i] == A[i - 1]) {
                reSum += A[i - 1];
                reNum++;
                i++;
            }
            if ((i == A.length || A[i] - A[i - 1] > 1) && reNum > 0) {
                int slots = i == A.length ? reNum : A[i] - A[i - 1] - 1;
                int d = Math.min(reNum, slots);
                newSum += A[i - 1] * d + d * (d + 1) / 2;
                reNum -= d;
            }
        }
        return newSum - reSum;
    }
}