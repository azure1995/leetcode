class Solution {
    Random rand;
    int[] rowSums;
    Integer[] initial;
    Map<Integer, List<Integer>> toChoose;

    public Solution(int n_rows, int n_cols) {
        this.rand = new Random();
        rowSums = new int[n_rows];
        initial = new Integer[n_cols];
        for (int i = 0; i < n_cols; i++) {
            initial[i] = i;
        }
        for (int i = 0; i < n_rows; i++) {
            rowSums[i] = (i + 1) * n_cols;
        }
        this.toChoose = new HashMap<>();
    }

    public int[] flip() {
        int pr = rand.nextInt(rowSums[rowSums.length - 1]);
        int row = 0;
        while (row < rowSums.length && rowSums[row] <= pr) {
            row++;
        }
        if (!toChoose.containsKey(row)) {
            toChoose.put(row, new LinkedList<>(Arrays.asList(initial)));
        }
        int colIndex = rand.nextInt(toChoose.get(row).size());
        int col = toChoose.get(row).get(colIndex);
        toChoose.get(row).remove(colIndex);
        for (int i = row; i < rowSums.length; i++) {
            rowSums[i]--;
        }
        return new int[] { row, col };
    }

    public void reset() {
        for (int i = 0; i < rowSums.length; i++) {
            rowSums[i] = (i + 1) * initial.length;
        }
        this.toChoose.clear();
    }
}