class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int can1 = nums[0], can2 = nums[0], count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (can1 == nums[i] || can2 == nums[i]) {
                if (can1 == nums[i]) {
                    count1++;
                } else {
                    count2++;
                }
            } else if (count1 == 0 || count2 == 0) {
                if (count1 == 0) {
                    can1 = nums[i];
                    count1++;
                } else {
                    can2 = nums[i];
                    count2++;
                }
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (can1 == num) {
                count1++;
            } else if (can2 == num) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(can1);
        }
        if (count2 > nums.length / 3) {
            result.add(can2);
        }
        return result;
    }
}
