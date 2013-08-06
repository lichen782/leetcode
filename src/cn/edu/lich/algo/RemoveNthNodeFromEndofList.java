package cn.edu.lich.algo;

import java.util.*;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * @author lich
 *
 */
public class RemoveNthNodeFromEndofList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head == null) return null;
		HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		int i = 0;
		ListNode p = head;
		while(p != null){
			map.put(++i, p);
			p = p.next;
		}
		ListNode pre = map.get(i - n);//i - n is the node that right BEFORE the to-be-deleted node.
		if(pre != null){
			ListNode deleted = pre.next;
			if(deleted != null)
				pre.next = deleted.next;
		}else {//if pre is null, means we are deleting head
			head = head.next;
		}
        return head;
    }
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if(head == null) return null;
		int[] counter = new int[]{0};
		return removeNthFromEnd2(head,n,counter);
	}
	
	private static ListNode removeNthFromEnd2(ListNode head, int n, int[] counter){
		if(head.next == null){// we reached tail
			counter[0] = 1;
		}else {
			head.next = removeNthFromEnd2(head.next, n, counter);
			counter[0]++;//we increment this counter to record when we back from the recursive, namely back from the last node
		}
		if(counter[0] == n){//oh, this is nth node backward, we just RETURN THE NEXT NODE.
			return head.next;
		}else return head;//otherwise return whatever we received
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}

}
