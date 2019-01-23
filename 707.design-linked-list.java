/*
 * [838] Design Linked List
 *
 * https://leetcode.com/problems/design-linked-list/description/
 *
 * algorithms
 * Easy (18.03%)
 * Total Accepted:    8.4K
 * Total Submissions: 46.7K
 * Testcase Example:  '["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\n[[],[1],[3],[1,2],[1],[1],[1]]'
 *
 * Design your implementation of the linked list. You can choose to use the
 * singly linked list or the doubly linked list. A Node in a singly linked list
 * should have two attributes: val and next. val is the value of the current
 * Node, and next is a pointer/reference to the next Node. If you want to use
 * the doubly linked list, you will need one more attribute prev to indicate
 * the previous Node in the linked list. Assume all Nodes in the linked list
 * are 0-indexed.
 * 
 * Implement these functions in your linked list class:
 * 
 * 
 * get(index) : Get the value of the index-th Node in the linked list. If the
 * index is invalid, return -1.
 * addAtHead(val) : Add a Node of value val before the first element of the
 * linked list. After the insertion, the new Node will be the first Node of the
 * linked list.
 * addAtTail(val) : Append a Node of value val to the last element of the
 * linked list.
 * addAtIndex(index, val) : Add a Node of value val before the index-th Node in
 * the linked list. If index equals to the length of linked list, the Node will
 * be appended to the end of linked list. If index is greater than the length,
 * the Node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th Node in the linked list, if the
 * index is valid.
 * 
 * 
 * Example:
 * 
 * 
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * 
 * 
 * Note:
 * 
 * 
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 * 
 */
class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    Node linkedList; 
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.linkedList = null;
    }
    
    /** Get the value of the index-th Node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node t = linkedList;
        for (int i = 0; i < index && t != null; i++) {
            t = t.next;
        }
        return t == null ? -1 : t.val;
    }
    
    /** Add a Node of value val before the first element of the linked list. After the insertion, the new Node will be the first Node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val, linkedList);
        linkedList = newHead;
    }
    
    /** Append a Node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node t = linkedList;
        if (t == null) {
            linkedList = new Node(val);
        } else {
            while (t.next != null) {
                t = t.next;
            }
            t.next = new Node(val);
        }
        
    }
    
    /** Add a Node of value val before the index-th Node in the linked list. If index equals to the length of linked list, the Node will be appended to the end of linked list. If index is greater than the length, the Node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node t = linkedList;
        Node pre = null;
        for (int i = 0; i < index; i++) {
            if (t == null) {
                return;
            } else {
                pre = t;
                t = t.next;
            }
        }
        Node newNode = new Node(val, t);
        pre.next = newNode;
    }
    
    /** Delete the index-th Node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (linkedList == null) {
            return;
        } else if (index == 0 && linkedList != null) {
            linkedList = linkedList.next;
            return;
        } 
        Node t = linkedList;
        Node pre = null;
        for (int i = 0; i < index; i++) {
            pre = t;
            t = t.next;
            if (t == null) {
                return;
            }
        }
        pre.next = t.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
