public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        return root.val + "(" + serialize(root.left) + ")" + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        int left = data.indexOf('(');
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(0, left== -1 ? data.length() : left)));
        if (left == -1) {
            return root;
        }
        int counter = 1;
        int right = left;
        do {
            right++;
            if (data.charAt(right) == '(') {
                counter++;
            } else if (data.charAt(right) == ')') {
                counter--;
            }
        } while (counter > 0);
        root.left = deserialize(data.substring(left + 1, right));
        root.right = deserialize(data.substring(right + 1, data.length()));
        return root;
    }
}