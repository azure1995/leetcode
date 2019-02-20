class Solution {
    public int totalFruit(int[] tree) {
        List<Integer> has = new LinkedList<>();
        int sum = 0;
        int ret = 0;
        int pre = 0;
        for (int i = 0; i < tree.length; i++) {
            int count = 1;
            int type = tree[i];
            while (i + 1 < tree.length && tree[i + 1] == type) {
                i++;
                count++;
            }
            if (has.size() < 2) {
                has.add(type);
            } else {
                if (has.size() == 2 && !has.contains(type)) {
                    sum = pre;
                }
                has.remove(0);
                has.add(type);
            }
            pre = count;
            sum += count;
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}
