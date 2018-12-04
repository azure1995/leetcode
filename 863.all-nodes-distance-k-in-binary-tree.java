class Solution {
    public List<Integer> helper(TreeNode root, int dist) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        } else if (dist == 0) {
            return Collections.singletonList(root.val);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(helper(root.left, dist - 1));
        list.addAll(helper(root.right, dist - 1));
        return list;
    }

    public void dfs(Map<TreeNode, TreeNode> map, TreeNode node) {
        if (node.left != null) {
            map.put(node.left, node);
            dfs(map, node.left);
        }
        if (node.right != null) {
            map.put(node.right, node);
            dfs(map, node.right);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> pMap = new HashMap<>();
        pMap.put(root, null);
        dfs(pMap, root);
        TreeNode cur = target, pre = null;
        List<Integer> ret = new ArrayList<>();
        for (int i = K; i >= 0 && cur != null; i--) {
            if (pre == null || i == 0) {
                ret.addAll(helper(cur, i));
            } else if (cur.left != null && cur.right != null) {
                ret.addAll(helper(pre.val == cur.left.val ? cur.right : cur.left, i - 1));
            }
            pre = cur;
            cur = pMap.get(cur);
        }
        return ret;
    }
}
