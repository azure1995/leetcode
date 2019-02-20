<<<<<<< HEAD
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftPointer, rightPointer;
        leftPointer = rightPointer = root;
        int depth = 0;
        while (leftPointer != null && rightPointer != null) {
            depth++;
            leftPointer = leftPointer.left;
            rightPointer = rightPointer.right;
        }
        if (leftPointer == null) {
            return (1 << depth) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
=======
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftPointer, rightPointer;
        leftPointer = rightPointer = root;
        int depth = 0;
        while (leftPointer != null && rightPointer != null) {
            depth++;
            leftPointer = leftPointer.left;
            rightPointer = rightPointer.right;
        }
        if (leftPointer == null) {
            return (1 << depth) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}