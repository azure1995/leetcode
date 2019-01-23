class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int len = arr.length;
        if (len % 2 == 0 || (len > 1 && arr[0].equals("#"))) {
            return false;
        }
        boolean[][] record = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            if (arr[i].equals("#")) {
                record[i][i] = true;
            }
        }
        for (int i = 2; i < len; i += 2) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j].equals("#")) {
                    record[j][j + i] = false;
                    continue;
                }
                for (int k = j + 1; k < j + i; k += 2) {
                    record[j][j + i] = record[j+1][k] && record[k+1][j + i];
                    if (record[j][j + i] == true) {
                        break;
                    }
                }
            }
        }
        return record[0][len-1];
    }
}