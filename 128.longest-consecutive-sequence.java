class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        int ret = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num + 1;
                int count = 1;
                while (set.contains(curNum)) {
                    count++;
                    curNum++;
                }
                ret = Math.max(ret, count);
            }
        }
        return ret;
    }
}