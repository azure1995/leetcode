class Solution {
    public int findMaxLength(int[] nums) {
        int diff = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                diff++;
            } else {
                diff--;
            }
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            } else {
                result = Math.max(result, i - map.get(diff));
            }
        }
        return result;
    }
}