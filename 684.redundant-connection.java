class Solution {
    public int getRoot(int n, int[] roots) {
        int root = n;
        while (root != roots[root]) {
            root = roots[root];
        }
        while (n != root) {
            roots[n] = root;
            n = roots[n];
        }
        return root;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] roots = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int root1 = getRoot(edges[i][0], roots);
            int root2 = getRoot(edges[i][1], roots);
            if (root1 == root2) {
                return edges[i];
            }
            roots[root2] = root1;
        }
        return null;
    }
}