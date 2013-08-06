package cn.edu.lich.algo;

import cn.edu.lich.algo.ListNode;

public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PartitionList pl = new PartitionList();
		ListNode head = ListNode.createListFrom(new int[] {1,4,3,2,5,2});
		System.out.println(head);
		System.out.println(pl.partition(head, 5));
	}

	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode dummy =new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode newHead = null;
		ListNode newTail = null;
		while(pre.next != null){
			if(pre.next.val < x){
				ListNode smaller = pre.next;
				pre.next = smaller.next;
				smaller.next = null;
				if(newHead == null){
					newHead = newTail = smaller;
				}else {
					newTail.next = smaller;
					newTail = smaller;
				}
			}else {
				pre = pre.next;
			}
		}
		if(newTail != null) newTail.next = dummy.next;
		else newHead = head;
		return newHead;
	}

}
