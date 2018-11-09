import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (39.94%)
 * Total Accepted:    168.6K
 * Total Submissions: 422K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    Map<Integer, Integer> map;
    List<List<Integer>> result;
    List<Integer> keys;

    public void get(int index, List<Integer> list) {
        if (index >= keys.size()) {
            result.add(list);
            return;
        }
        int key = keys.get(index);
        List<Integer> toAdd = new ArrayList<>();
        for (int i = 0; i <= map.get(key); i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.addAll(toAdd);
            toAdd.add(key);
            get(index + 1, newList);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        map = new HashMap<>();
        result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        keys = new ArrayList<>(map.keySet());
        get(0, new ArrayList<>());
        return result;
    }
}
