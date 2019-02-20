class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> a > b ? -1 : 1);
        left.addAll(list.subList(0, (k + 1) / 2));
        PriorityQueue<Integer> right = new PriorityQueue<>(list.subList((k + 1) / 2, k));
        double[] ret = new double[nums.length - k + 1];
        ret[0] = k % 2 == 0 ? left.peek() / 2.0 + right.peek() / 2.0 : left.peek() + 0.0;
        for (int i = k; i < nums.length; i++) {
            if (right.isEmpty() || nums[i - k] < right.peek()) {
                left.remove(nums[i - k]);
                if (right.isEmpty() || nums[i] <= right.peek()) {
                    left.add(nums[i]);
                } else {
                    left.add(right.poll());
                    right.add(nums[i]);
                }
            } else {
                right.remove(nums[i - k]);
                if (nums[i] >= left.peek()) {
                    right.add(nums[i]);
                } else {
                    right.add(left.poll());
                    left.add(nums[i]);
                }
            }
            ret[i - k + 1] = k % 2 == 0 ? left.peek() / 2.0 + right.peek() / 2.0 : left.peek() + 0.0;
        }
        return ret;
    }
}
