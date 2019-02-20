<<<<<<< HEAD
class Solution {
    public int min(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        for (int val : arr) {
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indexArray = new int[primes.length];
        int[] next_multiple = primes.clone();
        int next_ugly = 1;
        for (int i = 1; i < n; i++) {
            next_ugly = min(next_multiple);
            ugly[i]=next_ugly;
            for (int j = 0; j < primes.length; j++) {
                if (next_ugly == next_multiple[j]) {
                    indexArray[j]++;
                    next_multiple[j] = ugly[indexArray[j]] * primes[j];
                }
            }
        }
        return next_ugly;
    }
=======
class Solution {
    public int min(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        for (int val : arr) {
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indexArray = new int[primes.length];
        int[] next_multiple = primes.clone();
        int next_ugly = 1;
        for (int i = 1; i < n; i++) {
            next_ugly = min(next_multiple);
            ugly[i]=next_ugly;
            for (int j = 0; j < primes.length; j++) {
                if (next_ugly == next_multiple[j]) {
                    indexArray[j]++;
                    next_multiple[j] = ugly[indexArray[j]] * primes[j];
                }
            }
        }
        return next_ugly;
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}