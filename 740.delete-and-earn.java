class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] max = new int[3];
        int pre = 0, preNum = 0, i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (i == 0) {
                max[0] = num * count;
                pre = max[0];
            } else {
                if (num > preNum + 1) {
                    max[i % 3] = max[(i + 2) % 3] + num * count;
                    pre = max[i % 3];
                } else {
                    int t = num * count + (i >= 2 ? max[(i + 1) % 3] : 0);
                    max[i % 3] = Math.max(pre, t);
                    pre = t;
                }
            }
            preNum = num;
            i++;
        }
        return max[(i - 1) % 3];
    }
}
