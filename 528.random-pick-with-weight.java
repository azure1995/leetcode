class Solution {
    Random rand;
    int[] wSums;

    public Solution(int[] w) {
        rand = new Random();
        wSums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            wSums[i] = i == 0 ? w[0] : wSums[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int p = rand.nextInt(wSums[wSums.length - 1]);
        int index = 0;
        while (p >= wSums[index]) {
            index++;
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */