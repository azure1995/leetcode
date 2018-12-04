class Solution {
    public boolean reorderedPowerOf2(int N) {
        if (N == 1_000_000_000) {
            return false;
        }
        char[] digits = String.valueOf(N).toCharArray();
        Arrays.sort(digits);
        String ns = String.valueOf(digits);
        int len = digits.length;
        int powerTwo = 1 << (int) (Math.log(Math.pow(10, len - 1)) / Math.log(2));
        while (String.valueOf(powerTwo).length() <= len) {
            char[] cs = String.valueOf(powerTwo).toCharArray();
            Arrays.sort(cs);
            String s = String.valueOf(cs);
            if (ns.equals(s)) {
                return true;
            }
            powerTwo *= 2;
        }
        return false;
    }
}
