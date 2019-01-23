class Solution {
    public int getVirtualIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }

    public void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] copy = A.clone();
        int n = A.length;
        int left = 0, right = n - 1;
        while (left < right) {
            if (copy[getVirtualIndex(left, n)] % 2 == 1) {
                left++;
            } else {
                swap(copy, getVirtualIndex(left, n), getVirtualIndex(right, n));
                right--;
            }
        }
        return copy;
    }
}