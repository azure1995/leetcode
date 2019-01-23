/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node[] get(Node head) {
        Node tail = head;
        while (tail != null) {
            if (tail.child != null) {
                Node[] afterFlatten = get(tail.child);
                tail.child = null;
                Node temp = tail.next;
                tail.next = afterFlatten[0];
                afterFlatten[0].prev = tail;
                tail = afterFlatten[1];
                if (temp == null) {
                    break;
                } else {
                    afterFlatten[1].next = temp;
                    temp.prev = afterFlatten[1];
                }
            } else if (tail.next == null) {
                break;
            }
            tail = tail.next;
        }
        return new Node[] { head, tail };
    }

    public Node flatten(Node head) {
        return get(head)[0];
    }
}