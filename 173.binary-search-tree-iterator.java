import java.util.Stack;

/*
 * [173] Binary Search Tree Iterator
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * algorithms
 * Medium (44.83%)
 * Total Accepted:    157.1K
 * Total Submissions: 350.4K
 * Testcase Example:  '[]'
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree. 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    boolean first;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            TreeNode firstNode = new TreeNode(0);
            firstNode.right = root;
            stack.push(firstNode);
            first = true;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            TreeNode rightRoot = top.right;
            do {
                stack.push(rightRoot);
                rightRoot = rightRoot.left;
            } while (rightRoot != null);
        }
        if (first) {
            first = false;
            return next();
        }
        return top.val;
    }
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
