class Solution {
    public String makeLargestSpecial(String S) {
        return helper(S);
    }

    private String helper(String S) {
        List<String> ms = new ArrayList<>();
        List<Integer> lows = new ArrayList<>();
        getMountains(S, ms, lows);
        for (int i = 0; i < ms.size(); i++) {
            ms.set(i, dealMountain(ms.get(i), lows.get(i)));
        }
        Collections.sort(ms, (a, b) -> b.compareTo(a));
        StringBuilder sb = new StringBuilder();
        for (String s : ms) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void getMountains(String S, List<String> ms, List<Integer> lows) {
        int count = 0, low = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        char[] chArr = S.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            count += chArr[i] == '1' ? 1 : -1;
            if (i + 1 < chArr.length && chArr[i] == '0' && chArr[i + 1] == '1') {
                low = Math.min(low, count);
            }
            sb.append(chArr[i]);
            if (count == 0) {
                ms.add(sb.toString());
                sb = new StringBuilder();
                lows.add(low);
                low = Integer.MAX_VALUE;
            }
        }
    }

    private String dealMountain(String S, int low) {
        if (low == Integer.MAX_VALUE) {
            return S;
        }
        return S.substring(0, low) + helper(S.substring(low, S.length() - low)) + S.substring(S.length() - low);
    }
}
