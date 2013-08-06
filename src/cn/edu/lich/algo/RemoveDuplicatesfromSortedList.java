package cn.edu.lich.algo;


public class RemoveDuplicatesfromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(3);
		System.out.println(head);
		
		RemoveDuplicatesfromSortedList rdsl = new RemoveDuplicatesfromSortedList();
		System.out.println(rdsl.removeDuplicates(head));
	}
	
	
	public ListNode removeDuplicates(ListNode head) {
		if(head == null) return null;
		ListNode fast = null;
		ListNode slow = null;
		slow = fast = head;
		while(fast.next != null){
			if(fast.next.val == slow.val){
				fast = fast.next;
			}else {
				if(slow != fast){
					slow.next = fast.next;
					ListNode pre = fast;
					fast = fast.next;
					pre.next = null;
					slow = slow.next;
				}else {
					slow = slow.next;
					fast = fast.next;
				}
			}
		}
		if(fast != slow) {
			slow.next = null;
		}
		return head;
	}

}
