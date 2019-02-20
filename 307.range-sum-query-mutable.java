<<<<<<< HEAD
class NumArray {
    int[] BIT;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.BIT = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        this.nums[i] = val;
        i = i + 1;
        while (i <= n) {
            BIT[i] += diff;
            i += (i & -i);
        }
    }

    public int getSum(int i) {
        int sum = 0;
        i = i + 1;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}
=======
class NumArray {
    int[] BIT;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.BIT = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        this.nums[i] = val;
        i = i + 1;
        while (i <= n) {
            BIT[i] += diff;
            i += (i & -i);
        }
    }

    public int getSum(int i) {
        int sum = 0;
        i = i + 1;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
