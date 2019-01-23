class Solution {
    private void reverse(int[] arr, int from, int to) {
        int left = from, right = to;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ret = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == A.length - i) continue;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] == A.length - i) {
                    if (j > 0) {
                        ret.add(j + 1);
                        reverse(A, 0, j);
                    }
                    ret.add(i + 1);
                    reverse(A, 0, i);
                    break;
                }
            }
        }
        ret.add(A.length);
        return ret;
    }
}