/*
 * [772] Construct Quad Tree
 *
 * https://leetcode.com/problems/construct-quad-tree/description/
 *
 * algorithms
 * Easy (48.37%)
 * Total Accepted:    1.8K
 * Total Submissions: 3.6K
 * Testcase Example:  '[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]'
 *
 * We want to use quad trees to store an N x N boolean grid. Each cell in the
 * grid can only be true or false. The root node represents the whole grid. For
 * each node, it will be subdivided into four children nodes until the values
 * in the region it represents are all the same.
 * 
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is
 * true if and only if the node is a leaf node. The val attribute for a leaf
 * node contains the value of the region it represents.
 * 
 * Your task is to use a quad tree to represent a given grid. The following
 * example may help you understand the problem better:
 * 
 * Given the 8 x 8 grid below, we want to construct the corresponding quad
 * tree:
 * 
 * 
 * 
 * It can be divided according to the definition above:
 * 
 * 
 * 
 * 
 * 
 * The corresponding quad tree should be as following, where each node is
 * represented as a (isLeaf, val) pair.
 * 
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * N is less than 1000 and guaranteened to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 * 
 * 
 */
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        int side = grid.length;
        Node[][] nodeGrid = new Node[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                nodeGrid[i][j] = new Node(grid[i][j] == 1, true, null, null, null, null);
            }
        }
        while (side > 1) {
            for (int i = 0; i < side; i += 2) {
                for (int j = 0; j < side; j += 2) {
                    boolean allLeafs = true;
                    boolean sameVal = true;
                    for (int d = 0; d < 2; d++) {
                        for (int r = 0; r < 2; r++) {
                            allLeafs &= nodeGrid[i + d][j + r].isLeaf;
                            sameVal &= (nodeGrid[i + d][j + r].val == nodeGrid[i][j].val); 
                        }
                    }
                    if (allLeafs && sameVal) {
                        nodeGrid[i/2][j/2] = nodeGrid[i][j];
                    } else {
                        nodeGrid[i/2][j/2] = new Node(true, false, nodeGrid[i][j], nodeGrid[i][j+1], 
                        nodeGrid[i+1][j], nodeGrid[i+1][j+1]);
                    }
                }
            }
            side /= 2;
        }     
        return nodeGrid[0][0];
    }
}
