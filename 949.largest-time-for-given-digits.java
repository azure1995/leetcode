class Solution {
    String ret;

    public void dfs(boolean[] visited, int[] A, String s) {
        if (s.length() == 4) {
            if (Integer.valueOf(s.substring(0, 2)) < 24 && Integer.valueOf(s.substring(2)) < 60
                    && s.compareTo(ret) > 0) {
                ret = s;
            }
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, A, s + A[i]);
                visited[i] = false;
            }
        }
    }

    public String largestTimeFromDigits(int[] A) {
        ret = "";
        dfs(new boolean[4], A, "");
        if (ret.length() == 0) {
            return "";
        } else {
            return ret.substring(0, 2) + ":" + ret.substring(2);
        }
    }
}
