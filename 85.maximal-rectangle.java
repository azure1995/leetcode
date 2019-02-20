class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] left1Num = new int[m][n];
        for (int r = 0; r < m; r++) {
            left1Num[r][0] = matrix[r][0] == '0' ? 0 : 1;
            for (int c = 1; c < n; c++) {
                left1Num[r][c] = matrix[r][c] == '0' ? 0 : left1Num[r][c - 1] + 1;
            }
        }
        int ret = 0;
        for (int c = 0; c < n; c++) {
            Stack<Integer> stack = new Stack<>();
            for (int r = 0; r <= m; r++) {
                while (!stack.isEmpty() && (r == m || left1Num[r][c] <= left1Num[stack.peek()][c])) {
                    int width = left1Num[stack.pop()][c];
                    int height = r - 1 - (stack.isEmpty() ? -1 : stack.peek());
                    ret = Math.max(ret, height * width);
                }
                stack.push(r);
            }
        }
        return ret;
    }
}