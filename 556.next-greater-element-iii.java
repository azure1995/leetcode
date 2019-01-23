class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int[] record = new int[10];
        record[n % 10] = digits.length - 1;
        for (int i = digits.length - 2; i >= 0; i--) {
            for (int j = digits[i] - '0' + 1; j < 10; j++) {
                if (record[j] > 0) {
                    char temp = (char) (j + '0');
                    digits[record[j]] = digits[i];
                    digits[i] = temp;
                    Arrays.sort(digits, i + 1, digits.length);
                    return Long.valueOf(String.valueOf(digits)) > Integer.MAX_VALUE ? -1
                            : Integer.valueOf(String.valueOf(digits));
                }
            }
            record[digits[i] - '0'] = i;
        }
        return -1;
    }
}