<<<<<<< HEAD
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        int[] preNum = new int[nums.length];
        int[] maxSub = new int[nums.length];
        int outerMax = 1;
        int outerIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int innerMax = 0;
            int innerIndex = -1;    
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && maxSub[j] > innerMax) {
                    innerMax = maxSub[j];
                    innerIndex = j;
                }
            }
            preNum[i] = innerIndex;
            maxSub[i] = innerMax + 1;
            if (innerMax + 1 > outerMax) {
                outerMax = innerMax + 1;
                outerIndex = i;
            }
        }
        List<Integer> result = new LinkedList<>();
        do {
            result.add(0, outerIndex);
            outerIndex = preNum[outerIndex];
        } while (outerIndex >= 0);
        return result;
    }
=======
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        int[] preNum = new int[nums.length];
        int[] maxSub = new int[nums.length];
        int outerMax = 1;
        int outerIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int innerMax = 0;
            int innerIndex = -1;    
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && maxSub[j] > innerMax) {
                    innerMax = maxSub[j];
                    innerIndex = j;
                }
            }
            preNum[i] = innerIndex;
            maxSub[i] = innerMax + 1;
            if (innerMax + 1 > outerMax) {
                outerMax = innerMax + 1;
                outerIndex = i;
            }
        }
        List<Integer> result = new LinkedList<>();
        do {
            result.add(0, outerIndex);
            outerIndex = preNum[outerIndex];
        } while (outerIndex >= 0);
        return result;
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}