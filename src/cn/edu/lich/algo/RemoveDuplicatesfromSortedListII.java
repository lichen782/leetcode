package cn.edu.lich.algo;

public class RemoveDuplicatesfromSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = ListNode.createListFrom(new int[] {1,1,1,2,3,3,3,4,4,5,6,6,6,6});
		RemoveDuplicatesfromSortedListII rdsl = new RemoveDuplicatesfromSortedListII();
		System.out.println(head);
		System.out.println(rdsl.deleteDuplicates(head));
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return head;
        ListNode dummy =  new ListNode(head.val - 1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast.next != null){
        	if(fast.next.val == fast.val){
        		fast = fast.next;
        	}else {
        		if(slow.next != fast){
        			slow.next = fast.next;
        			fast.next = null;
        			fast = slow.next;
        		}else {
        			slow = fast;
        			fast = fast.next;
        		}
        	}
        }
        if(slow.next != fast){
        	slow.next = null;
        }
        return dummy.next;
    }
}
