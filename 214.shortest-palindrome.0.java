class Solution {
    public String shortestPalindrome(String s) {
        String re = new StringBuilder(s).reverse().toString();
        String ns = s + "#" + re;
        char[] chArr = ns.toCharArray();
        int[] memo = new int[chArr.length];
        for (int i = 1; i < chArr.length; i++) {
            int tmp = memo[i - 1];
            while (tmp > 0 && chArr[i] != chArr[tmp]) {
                tmp = memo[tmp - 1];
            }
            memo[i] = chArr[i] == chArr[tmp] ? tmp + 1 : tmp;
        }
        return re + s.substring(memo[chArr.length - 1]);
    }
}