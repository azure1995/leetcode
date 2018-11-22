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