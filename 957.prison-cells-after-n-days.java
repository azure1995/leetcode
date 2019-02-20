class Solution {
    public int get(int[] cells) {
        int ret = 0;
        for (int i = 0; i < 8; i++) {
            ret += cells[i] * (1 << (7 - i));
        }
        return ret;
    }

    public void change(int[] cells) {
        int[] temp = cells.clone();
        cells[0] = cells[7] = 0;
        for (int i = 1; i <= 6; i++) {
            cells[i] = temp[i - 1] == temp[i + 1] ? 1 : 0;
        }
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int k = 0, cur = get(cells);
        do {
            set.add(cur);
            list.add(cur);
            change(cells);
            cur = get(cells);
            k++;
        } while (k < N && !set.contains(cur));
        if (k == N) {
            return cells;
        } else {
            int index = list.indexOf(cur);
            int end = list.get((N - index) % (list.size() - index) + index);
            int[] ret = new int[8];
            for (int i = 0; i < 8; i++) {
                ret[7 - i] = (end >> i) & 1;
            }
            return ret;
        }
    }
}
