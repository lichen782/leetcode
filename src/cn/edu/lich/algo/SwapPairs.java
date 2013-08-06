package cn.edu.lich.algo;

public class SwapPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);

		System.out.println(swapPairs(head));
	}
	
	public static ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head == null) return head;
		ListNode pp = null;
        ListNode p = head;
        ListNode c = head.next;
        while(c != null){
        	p.next = c.next;
        	c.next = p;
        	if(pp == null) head = c;
        	else {
        		pp.next = c;
        	}
        	pp = p;
        	p = p.next;
        	if(p == null)break;
        	c = p.next;
        }
        return head;
    }
	
	public static class ListNode {
	    int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(val);
			ListNode p = next;
			while(p!= null) {
				sb.append(p.val);
				p = p.next;
			}
			return sb.toString();
		}
	 }

}
