<<<<<<< HEAD
/*
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (41.27%)
 * Total Accepted:    24.7K
 * Total Submissions: 59.8K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1: 
 * 
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * The following are two duplicate subtrees:
 * 
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * and
 * 
 * 
 * ⁠   4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    }
}
=======
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int global_id = 0;
    Map<String, Integer> map = new HashMap<>();
    Set<Integer> dup = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();

    public int idAllocator() {
        return ++global_id;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftID = traverse(root.left);
        int rightID = traverse(root.right);
        String stringID = leftID + "|" + root.val + "|" + rightID;
        if (!map.containsKey(stringID)) {
            map.put(stringID, idAllocator());
        } else if (dup.add(map.get(stringID))) {
            list.add(root);
        }
        return map.get(stringID);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return list;
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
