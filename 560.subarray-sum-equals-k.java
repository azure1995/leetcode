class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int acc = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i];
            if (map.containsKey(acc - k)) {
                result += map.get(acc - k);
            }
            map.put(acc, map.containsKey(acc) ? map.get(acc) + 1 : 1);
        }
        return result;
    }
}