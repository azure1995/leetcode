class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        Map<Integer, int[]> memo = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int counter = 0, c1 = 0, c2 = 0, len1 = s1.length(), len2 = s2.length();
        char[] chArr1 = s1.toCharArray(), chArr2 = s2.toCharArray();
        while (c1 < n1 * s1.length()) {
            list.add(c1, counter);
            int i1 = c1 % len1, i2 = c2 % len2;
            if (chArr1[i1] == chArr2[i2]) {
                if (i2 == 0) {
                    if (memo.containsKey(i1)) {
                        int preLen = memo.get(i1)[0];
                        int period1 = c1 - preLen;
                        int period2 = counter - memo.get(i1)[1];
                        int tmp = (n1 * s1.length() - preLen) % period1 + preLen;
                        int other = list.get(tmp);
                        int N = other + (n1 * s1.length() - preLen) / period1 * period2;
                        return N / n2;
                    }
                    memo.put(i1, new int[] { c1, counter });
                }
                if (++c2 % len2 == 0) counter++;
            }
            c1++;
        }
        return counter / n2;
    }
}