class Solution {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        if (sum % machines.length != 0) {
            return -1;
        }
        int toLeft = 0, avg = sum / machines.length;
        int ret = 0;
        for (int load : machines) {
            int toRight = load - avg - toLeft;
            ret = Math.max(ret, Math.max(Math.max(toLeft, toRight), toLeft + toRight));
            toLeft = -toRight;
        }
        return ret;
    }
}