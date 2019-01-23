class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] ret = new int[k];
        for (int p1 = Math.max(0, k - len2); p1 <= Math.min(len1, k); p1++) {
            int[] maxArr1 = maxArr(nums1, p1), maxArr2 = maxArr(nums2, k - p1);
            int[] candidate = merge(maxArr1, maxArr2);
            if (greater(candidate, 0, ret, 0)) {
                ret = candidate;
            }
        }
        return ret;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int[] ret = new int[len1 + len2];
        for (int i = 0, i1 = 0, i2 = 0; i1 < len1 || i2 < len2; i++) {
            ret[i] = greater(arr1, i1, arr2, i2) ? arr1[i1++] : arr2[i2++];
        }
        return ret;
    }

    private boolean greater(int[] arr1, int i1, int[] arr2, int i2) {
        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] != arr2[i2]) {
                return arr1[i1] > arr2[i2];
            }
            i1++;
            i2++;
        }
        return i2 == arr2.length;
    }

    private int[] maxArr(int[] arr, int k) {
        int[] ret = new int[k];
        int len = arr.length;
        for (int i = 0, j = 0; i < len; i++) {
            while (len + j - i > k && j > 0 && ret[j - 1] < arr[i]) {
                j--;
            }
            if (j < k) {
                ret[j++] = arr[i];
            }
        }
        return ret;
    }
}
