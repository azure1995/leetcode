class Solution {
    public int[] threeEqualParts(int[] A) {
        int ones = 0;
        for (int a : A) ones += a;
        if (ones == 0) return new int[] {0, 2};
        if (ones % 3 != 0) return new int[] {-1, -1};
        int T = ones / 3;
        int[][] arr = new int[3][2];
        int[] exts = new int[3];
        String[] ss = new String[3];
        for (int i = 0, counter = 0, j = 0; i < A.length && j < 3; i++) {
            counter += A[i];
            if (counter == 0 && A[i] == 0) {
                exts[j]++;
            }
            if (counter == 1) {
                arr[j][0] = i;
            } 
            if (counter == T) {
                arr[j][1] = i;
                counter = 0;
                ss[j] = get(A, arr[j][0], arr[j][1]);
                j++;
            }
        }
        if (!ss[0].equals(ss[1]) || !ss[0].equals(ss[2])) return new int[] {-1, -1};
        int ext = A.length - 1 - arr[2][1];
        if (exts[1] < ext || exts[2] < ext) return new int[] {-1, -1};
        return new int[] {arr[0][1] + ext, arr[1][1] + ext + 1};
    }
    
    private String get(int[] arr, int from, int to) {
        StringBuilder sb = new StringBuilder();
        for (int i = from; i <= to; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}