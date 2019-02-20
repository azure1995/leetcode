class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int ret = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0, pre1 = -1, last1 = -1; i <= A.length; i++) {
            if (i < A.length && A[i] == 0) continue;
            if (list.size() < S) {
                list.add(i);
                if (list.size() == S) last1 = i;
            } else {
                if (S == 0) {
                    ret += (i - pre1) * (i - pre1 - 1) / 2;
                    pre1 = i;
                } else {
                    ret += (list.get(0) - pre1) * (i - last1);
                    pre1 = list.remove(0);
                    list.add(i);   
                    last1 = i;   
                }
            }   
        }
        return ret;
    }
}