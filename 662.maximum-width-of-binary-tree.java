class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Long> map = new HashMap<>();
        map.put(root, 0l);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode pre = null;
        TreeNode left = null;
        int maxWidth = 1;
        while (true) {
            TreeNode head = queue.remove();
            if (head == null) {
                if (pre == null) {
                    break;
                }
                maxWidth = Math.max(maxWidth, (int) (map.get(pre) - map.get(left) + 1));
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                pre = null;
            } else {
                if (head.left != null) {
                    map.put(head.left, map.get(head) * 2);
                    queue.add(head.left);
                    if (pre == null) {
                        left = head.left;
                    }
                    pre = head.left;
                }
                if (head.right != null) {
                    map.put(head.right, map.get(head) * 2 + 1);
                    queue.add(head.right);
                    if (pre == null) {
                        left = head.right;
                    }
                    pre = head.right;
                }
            }
        }
        return maxWidth;
    }
}
