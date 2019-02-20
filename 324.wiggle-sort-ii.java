<<<<<<< HEAD
import java.util.PriorityQueue;

/*
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (26.70%)
 * Total Accepted:    46.4K
 * Total Submissions: 173.7K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int mid = getMid(nums);
        int n = nums.length;
        int i = 0, left = 0, right = n - 1;
        while (i <= right) {
            if (nums[getVirtualIndex(i, n)] > mid) {
                swap(nums, getVirtualIndex(i, n), getVirtualIndex(left, n));
                i++;
                left++;
            } else if (nums[getVirtualIndex(i, n)] < mid) {
                swap(nums, getVirtualIndex(i, n), getVirtualIndex(right, n));
                right--;
            } else {
                i++;
            }
        }
    }

    public int getMid(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > (nums.length + 1) / 2) {
                priorityQueue.remove();
            }
        }
        return priorityQueue.remove();
    }
    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public int getVirtualIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }
}
=======
import java.util.PriorityQueue;

/*
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (26.70%)
 * Total Accepted:    46.4K
 * Total Submissions: 173.7K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int mid = getMid(nums);
        int n = nums.length;
        int i = 0, left = 0, right = n - 1;
        while (i <= right) {
            if (nums[getVirtualIndex(i, n)] > mid) {
                swap(nums, getVirtualIndex(i, n), getVirtualIndex(left, n));
                i++;
                left++;
            } else if (nums[getVirtualIndex(i, n)] < mid) {
                swap(nums, getVirtualIndex(i, n), getVirtualIndex(right, n));
                right--;
            } else {
                i++;
            }
        }
    }

    public int getMid(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > (nums.length + 1) / 2) {
                priorityQueue.remove();
            }
        }
        return priorityQueue.remove();
    }
    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public int getVirtualIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
