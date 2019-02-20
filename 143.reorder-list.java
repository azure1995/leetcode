<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

/*
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (28.32%)
 * Total Accepted:    127.6K
 * Total Submissions: 450.5K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return;
        }
        ListNode node = head.next;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int forward = 0, backward = list.size() - 1;
        ListNode cur = head;
        while (forward < backward) {
            cur.next = list.get(backward--);
            cur.next.next = list.get(forward++);
            cur = cur.next.next;
        }
        if (forward == backward) {
            cur.next = list.get(forward);
            cur = cur.next;
        }
        cur.next = null;
    }
}
=======
import java.util.ArrayList;
import java.util.List;

/*
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (28.32%)
 * Total Accepted:    127.6K
 * Total Submissions: 450.5K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return;
        }
        ListNode node = head.next;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int forward = 0, backward = list.size() - 1;
        ListNode cur = head;
        while (forward < backward) {
            cur.next = list.get(backward--);
            cur.next.next = list.get(forward++);
            cur = cur.next.next;
        }
        if (forward == backward) {
            cur.next = list.get(forward);
            cur = cur.next;
        }
        cur.next = null;
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
