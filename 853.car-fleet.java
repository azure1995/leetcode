class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(position[i], i);
        }
        Arrays.sort(position);
        double[] time = new double[N];
        for (int i = 0; i < N; i++) {
            time[i] = (0.0 + target - position[i]) / speed[map.get(position[i])];
        }
        double[] max = new double[N + 1];
        for (int i = N - 1; i > 0; i--) {
            max[i] = Math.max(time[i], max[i + 1]);
        }
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (time[i] > max[i + 1]) {
                ret++;
            }
        }
        return ret;
    }
}
