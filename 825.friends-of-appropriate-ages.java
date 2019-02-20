class Solution {
    final int limit = 120;

    public int numFriendRequests(int[] ages) {
        int[] count = new int[limit + 1];
        for (int i = 0; i < ages.length; i++) {
            count[ages[i]]++;
        }
        int ret = 0;
        int[] sums = new int[limit + 1];
        for (int age = 1; age <= limit; age++) {
            sums[age] = sums[age - 1] + count[age];
            if (count[age] == 0) continue;
            int min = age / 2 + 7;
            ret += (age > min ? count[age] * (sums[age] - 1 - sums[min]) : 0);
        }
        return ret;
    }
}
