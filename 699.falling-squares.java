class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        Set<Integer> coords = new HashSet();
        for (int[] pos : positions) {
            coords.add(pos[0]);
            coords.add(pos[0] + pos[1] - 1);
        }
        List<Integer> sortedCoords = new ArrayList(coords);
        Collections.sort(sortedCoords);
        Map<Integer, Integer> index = new HashMap();
        int t = 0;
        for (int coord : sortedCoords)
            index.put(coord, t++);
        SegmentTree tree = new SegmentTree(sortedCoords.size());
        int best = 0;
        List<Integer> ans = new ArrayList();
        for (int[] pos : positions) {
            int L = index.get(pos[0]);
            int R = index.get(pos[0] + pos[1] - 1);
            int h = tree.query(0, 0, t - 1, L, R) + pos[1];
            tree.update(0, 0, t - 1, L, R, h);
            best = Math.max(best, h);
            ans.add(best);
        }
        return ans;
    }
}

class SegmentTree {
    int N;
    int[] tree, lazy;

    SegmentTree(int N) {
        this.N = N;
        tree = new int[3 * N];
        lazy = new int[3 * N];
    }

    public void update(int treeIndex, int lo, int hi, int i, int j, int h) {
        if (lazy[treeIndex] != 0) { // this node is lazy
            tree[treeIndex] = Math.max(tree[treeIndex], lazy[treeIndex]); // normalize current node by removing laziness
            if (lo != hi) { // update lazy[] for children nodes
                lazy[2 * treeIndex + 1] = Math.max(lazy[2 * treeIndex + 1], lazy[treeIndex]);
                lazy[2 * treeIndex + 2] = Math.max(lazy[2 * treeIndex + 2], lazy[treeIndex]);
            }
            lazy[treeIndex] = 0; // current node processed. No longer lazy
        }
        if (lo > hi || lo > j || hi < i)
            return; // out of range. escape.
        
            
        int mid = lo + (hi - lo) / 2; // recurse deeper for appropriate child
        update(2 * treeIndex + 1, lo, mid, i, j, h);
        update(2 * treeIndex + 2, mid + 1, hi, i, j, h);
        tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public int query(int treeIndex, int lo, int hi, int i, int j) {
        if (lo > j || hi < i) // segment completely outside range
            return 0; // represents a null node
        if (lazy[treeIndex] != 0) { // this node is lazy
            tree[treeIndex] = Math.max(tree[treeIndex], lazy[treeIndex]); // normalize current node by removing laziness
            if (lo != hi) { // update lazy[] for children nodes
                lazy[2 * treeIndex + 1] = Math.max(lazy[2 * treeIndex + 1], lazy[treeIndex]);
                lazy[2 * treeIndex + 2] = Math.max(lazy[2 * treeIndex + 2], lazy[treeIndex]);
            }
            lazy[treeIndex] = 0; // current node processed. No longer lazy
        }
        if (i <= lo && j >= hi) // segment completely inside range
            return tree[treeIndex];
        int mid = lo + (hi - lo) / 2; // partial overlap of current segment and queried range. Recurse deeper.
        int leftQuery = query(2 * treeIndex + 1, lo, mid, i, j);
        int rightQuery = query(2 * treeIndex + 2, mid + 1, hi, i, j);
        return Math.max(leftQuery, rightQuery);
    }
}
