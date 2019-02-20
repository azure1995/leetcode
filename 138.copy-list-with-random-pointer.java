<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;

/*
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (25.58%)
 * Total Accepted:    187K
 * Total Submissions: 730.8K
 * Testcase Example:  '{}'
 *
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * 
 * 
 * Return a deep copy of the list.
 * 
 */
/**
 * Definition for singly-linked list with a random pointer. class RandomListNode
 * { int label; RandomListNode next, random; RandomListNode(int x) { this.label
 * = x; } };
 */
public class Solution {
    Map<Integer, RandomListNode> clonedOnes = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode clone = new RandomListNode(head.label);
        clonedOnes.put(head.label, clone);
        if (head.next != null) {
            if (!clonedOnes.containsKey(head.next.label)) {
                clone.next = copyRandomList(head.next);
            } else {
                clone.next = clonedOnes.get(head.next.label);
            }
        }
        if (head.random != null) {
            if (!clonedOnes.containsKey(head.random.label)) {
                clone.random = copyRandomList(head.random);
            } else {
                clone.random = clonedOnes.get(head.random.label);
            }
        }
        return clone;
    }
}
=======
import java.util.HashMap;
import java.util.Map;

/*
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (25.58%)
 * Total Accepted:    187K
 * Total Submissions: 730.8K
 * Testcase Example:  '{}'
 *
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * 
 * 
 * Return a deep copy of the list.
 * 
 */
/**
 * Definition for singly-linked list with a random pointer. class RandomListNode
 * { int label; RandomListNode next, random; RandomListNode(int x) { this.label
 * = x; } };
 */
public class Solution {
    Map<Integer, RandomListNode> clonedOnes = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode clone = new RandomListNode(head.label);
        clonedOnes.put(head.label, clone);
        if (head.next != null) {
            if (!clonedOnes.containsKey(head.next.label)) {
                clone.next = copyRandomList(head.next);
            } else {
                clone.next = clonedOnes.get(head.next.label);
            }
        }
        if (head.random != null) {
            if (!clonedOnes.containsKey(head.random.label)) {
                clone.random = copyRandomList(head.random);
            } else {
                clone.random = clonedOnes.get(head.random.label);
            }
        }
        return clone;
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
