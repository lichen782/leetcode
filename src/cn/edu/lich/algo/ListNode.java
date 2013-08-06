package cn.edu.lich.algo;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	val = x;
	next = null;
	}
	
	@Override
	public String toString() {
		return val + (next == null ? "" : next.toString());
	}
	
	public static ListNode createListFrom(int[] A){
		ListNode head = null;
		ListNode tail = null;
		for(int i = 0; i < A.length; i++){
			ListNode p = new ListNode(A[i]);
			if(head == null){
				tail = head = p;
			}else {
				tail.next = p;
				tail = tail.next;
			}
		}
		return head;
	}
}
