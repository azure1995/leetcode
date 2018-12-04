class Solution {
    final int limit = Integer.MAX_VALUE;

    public List<Integer> splitIntoFibonacci(String S) {
        int l1 = S.charAt(0) == '0' ? 1 : 10;
        for (int i = 1; i <= l1; i++) {
            long num1 = Long.valueOf(S.substring(0, i));
            if (i >= S.length() || num1 > limit)
                break;
            int l2 = S.charAt(i) == '0' ? i + 1 : i + 10;
            for (int j = i + 1; j <= l2; j++) {
                long num2 = Long.valueOf(S.substring(i, j));
                if (j >= S.length() || num2 > limit)
                    break;
                int k = j;
                List<Integer> list = new ArrayList<>();
                int f1 = (int) num1, f2 = (int) num2;
                list.add(f1);
                list.add(f2);
                while (k < S.length() && 0l + f1 + f2 <= limit) {
                    String sum = String.valueOf(f1 + f2);
                    if (k + sum.length() > S.length() || !S.substring(k, k + sum.length()).equals(sum)) {
                        break;
                    }
                    f1 = f2;
                    f2 = Integer.valueOf(sum);
                    list.add(f2);
                    k += sum.length();
                }
                if (k == S.length() && list.size() >= 3) {
                    return list;
                }
            }
        }
        return Collections.EMPTY_LIST;
    }
}
