class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[] { i, nums[i] });
        }
        List<Integer> ret = new ArrayList<>(Collections.nCopies(nums.length, 0));
        mergeSort_count(list, 0, nums.length, ret);
        return ret;
    }

    private void merge(List<int[]> list, int from, int mid, int to, List<Integer> ret) {
        List<int[]> left = new ArrayList<>(list.subList(from, mid));
        List<int[]> right = new ArrayList<>(list.subList(mid, to));
        for (int i = to - 1, il = left.size() - 1, ir = right.size() - 1; i >= from; i--) {
            if (ir < 0 || il >= 0 && left.get(il)[1] > right.get(ir)[1]) {
                list.set(i, left.get(il));
                ret.set(left.get(il)[0], ret.get(left.get(il)[0]) + ir + 1);
                il--;
            } else {
                list.set(i, right.get(ir));
                ir--;
            }
        }
    }

    private void mergeSort_count(List<int[]> list, int from, int to, List<Integer> ret) {
        if (to - from <= 1) {
            return;
        }
        int mid = from + (to - from) / 2;
        mergeSort_count(list, from, mid, ret);
        mergeSort_count(list, mid, to, ret);
        merge(list, from, mid, to, ret);
    }
}