import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/*
 * [776] N-ary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (61.86%)
 * Total Accepted:    10.9K
 * Total Submissions: 17.6K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * 
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * 
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        boolean revisit = false;
        while (!stack.isEmpty()) {
            Node n = stack.peek();
            if (n == null) {
                stack.pop();
                revisit = true;
                continue;
            }
            if (n.children.size() == 0 || revisit == true) {
                ans.add(n.val);
                stack.pop();
                revisit = false;
            } else {
                stack.push(null);
                for (int i = n.children.size() - 1; i >= 0; i--) {
                    stack.push(n.children.get(i));
                }
            }
        }
        return ans;
    }
}
