class Solution {
    public int maxChunksToSorted(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);
        }
        int ans = 0;
        for (int i = 0; i < arr.length;) {
            int l = 0;
            do {
                pq.remove(arr[i]);
                l = Math.max(l, arr[i]);
                i++;
            } while (!pq.isEmpty() && l > pq.peek());
            ans++;
        }
        return ans;
    }
}