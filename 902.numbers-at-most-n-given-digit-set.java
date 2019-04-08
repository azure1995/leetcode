class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        List<String> list = Arrays.asList(D);
        char[] digits = ("" + N).toCharArray();
        int len = digits.length;
        int d = D.length;
        int ans = d == 1 ? len - 1 : (((int) Math.pow(d, len)) - d) / (d - 1);
        int coef = 1;
        boolean[] is = new boolean[len + 1];
        is[0] = true;
        for (int i = 0; i < len; i++) {
            is[i + 1] = list.contains(digits[i] + "") & is[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            if (is[i]) {
                int index = Collections.binarySearch(list, digits[i] + "");
                if (index < 0) index = - index - 1;
                ans += index * coef;    
            }
            coef *= d;
        }
        return is[len] ? ans + 1 : ans;
    }
}