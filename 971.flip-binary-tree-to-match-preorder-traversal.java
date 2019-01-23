/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ret = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        dfs(root, map);
        if (map.get(root) == voyage.length && helper(root, voyage, map, ret)) {
            return ret;
        }
        return Collections.singletonList(-1);
    }

    private boolean helper(TreeNode root, int[] voyage, Map<TreeNode, Integer> map, List<Integer> ret) {
        if (root == null && voyage.length == 0) {
            return true;
        }
        if (root.val != voyage[0]) {
            return false;
        }
        if (helper(root.left, Arrays.copyOfRange(voyage, 1, 1 + map.get(root.left)), map, ret)
                && helper(root.right, Arrays.copyOfRange(voyage, 1 + map.get(root.left), map.get(root)), map, ret)) {
            return true;
        } else if (helper(root.left, Arrays.copyOfRange(voyage, 1 + map.get(root.right), map.get(root)), map, ret)
                && helper(root.right, Arrays.copyOfRange(voyage, 1, 1 + map.get(root.right)), map, ret)) {
            ret.add(root.val);
            return true;
        }
        return false;
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        map.put(root, 1 + dfs(root.left, map) + dfs(root.right, map));
        return map.get(root);
    }
}
