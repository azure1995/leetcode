class Solution {
    public void dfs(int i, int[] quiet, List<List<Integer>> lists, int[] ret) {
        int p = i;
        int q = quiet[i];
        for (int k = 0; k < lists.get(i).size(); k++) {
            int next = lists.get(i).get(k);
            if (ret[next] == -1) {
                dfs(next, quiet, lists, ret);  
            } 
            if (q > quiet[ret[next]]) {
                q = quiet[ret[next]];
                p = ret[next];
            }
        }
        ret[i] = p;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < richer.length; i++) {
            lists.get(richer[i][1]).add(richer[i][0]);
        }
        int[] ret = new int[N];
        Arrays.fill(ret, -1);
        for (int i = 0; i < N; i++) {
            if (ret[i] == -1) {
                dfs(i, quiet, lists, ret);
            }
        }
        return ret;
    }
}
