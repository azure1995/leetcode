class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int width = Math.max(1, (max - min) / (nums.length - 1));
        Bucket[] buckets = new Bucket[(max - min) / width + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        for (int num : nums) {
            int bi = (num - min) / width;
            buckets[bi].contained = true;
            buckets[bi].min = Math.min(buckets[bi].min, num);
            buckets[bi].max = Math.max(buckets[bi].max, num);
        }
        int ret = 0;
        for (int i = 1, preMax = buckets[0].max; i < buckets.length; i++) {
            if (!buckets[i].contained) continue; 
            ret = Math.max(ret, buckets[i].min - preMax);
            preMax = buckets[i].max;
        }
        return ret;
    }

    class Bucket {
        boolean contained = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
}
