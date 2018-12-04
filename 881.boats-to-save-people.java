class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, h = people.length - 1;
        int ret = 0;
        while (l < h) {
            if (people[l] + people[h] > limit) {
                h--;
            } else {
                l++;
                h--;
            }
            ret++;
        }
        return l == h ? ret + 1 : ret;
    }
}
