/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            sb.append("," + (head.left == null ? "null" : head.left.val));
            if (head.left != null) {
                queue.offer(head.left);
            }
            sb.append("," + (head.right == null ? "null" : head.right.val));
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] vals = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.valueOf(vals[i++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            if (!vals[i].equals("null")) {
                r.left = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(r.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                r.right = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(r.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));