class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int large = Math.max(x, y), small = Math.min(x, y);
        if (large == 1) {
            return bound >= 2 ? Collections.singletonList(2) : Collections.EMPTY_LIST;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= (small == 1 ? 0 : (int) (Math.log(bound) / Math.log(small))); i++) {
            for (int j = 0; j <= (int) (Math.log(bound - Math.pow(x, i)) / Math.log(y)); j++) {
                set.add((int) Math.pow(x, i) + (int) Math.pow(y, j));
            }
        }
        return new ArrayList(set);
    }
}