class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if (N == 0) {
            return new int[] {};
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[N - k + 1];
        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                ret[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ret;
    }
}