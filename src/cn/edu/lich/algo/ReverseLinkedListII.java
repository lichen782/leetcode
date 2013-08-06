package cn.edu.lich.algo;

public class ReverseLinkedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = ListNode.createListFrom(new int[]{1,2,3,4,5});
		ReverseLinkedListII rl = new ReverseLinkedListII();
		System.out.println(head);
		System.out.println(rl.reverseBetween(head, 1,2));
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre_mth = dummy;
		ListNode nth_next = dummy;
		int i = n - m + 2;
		while(i > 0 && nth_next != null){
			nth_next = nth_next.next;
			i--;
		}
		i = m - 1;
		while(i > 0 && nth_next != null){
			pre_mth = pre_mth.next;
			nth_next = nth_next.next;
			i--;
		}
		
		ListNode last = pre_mth.next;
		while(last.next != nth_next){
			ListNode next = last.next;
			last.next = next.next;
			next.next = pre_mth.next;
			pre_mth.next = next;
		}
		
		return dummy.next;
    }

}
