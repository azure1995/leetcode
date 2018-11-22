class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr, x);
        int counter = 1, left, right;
        if (index < 0) {
            index = -index - 1;
            counter = 0;
            left = index - 1;
            right = index;
        } else {
            counter = 1;
            left = index - 1;
            right = index + 1;
        }
        while (counter < k) {
            if (right >= arr.length || (left >= 0 && x - arr[left] <= arr[right] - x)) {
                left--;
            } else {
                right++;
            }
            counter++;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }
}