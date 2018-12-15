/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {

    List<TreeNode> nodes;

    public CBTInserter(TreeNode root) {
        this.nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            nodes.add(r);
            if (r.left != null) {
                queue.offer(r.left);
            }
            if (r.right != null) {
                queue.offer(r.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        nodes.add(node);
        TreeNode p = nodes.get(nodes.size() / 2 - 1);
        if (p.left == null) {
            p.left = node;
        } else {
            p.right = node;
        }
        return p.val;
    }

    public TreeNode get_root() {
        return nodes.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such: CBTInserter
 * obj = new CBTInserter(root); int param_1 = obj.insert(v); TreeNode param_2 =
 * obj.get_root();
 */
