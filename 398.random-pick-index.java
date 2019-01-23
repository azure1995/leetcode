class Solution {
    Map<Integer, List<Integer>> map;
    Random rand;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        rand = new Random();
    }

    public int pick(int target) {
        List<Integer> listOfIndex = map.get(target);
        return listOfIndex.get(rand.nextInt(listOfIndex.size()));
    }
}