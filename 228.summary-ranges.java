class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            StringBuilder toAdd = new StringBuilder(String.valueOf(nums[start]));
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (i > start) {
                toAdd.append("->" + nums[i]);
            }
            result.add(toAdd.toString());
        }
        return result;
    }
}