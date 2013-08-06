package cn.edu.lich.algo;


public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println(reverseKGroup2(head,8));
		//how to reverse a link list:
//		ListNode dummy = new ListNode(0);
//		dummy.next = head;
//		ListNode pre = dummy;
//		ListNode cur = head.next;
//		ListNode last = head;
//		while(cur != null){
//			last.next = cur.next;
//			cur.next = pre.next;
//			pre.next = cur;
//			cur = last.next;
//		}
//		head = dummy.next;
//		System.out.println(head);
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ListNode firstGHead = head;
		int idx = 0;
		ListNode pp = null;
		while(head != null) {
	        ListNode c = head;
	        if(k <= 1 || c == null)return firstGHead;
	        for(int i = 0; i < k - 1&& c != null;i++) {
	        	c = c.next;
	        }
	        if(c == null) break; 
	        c = head;//save original head
	        int i = k - 1;
	    	ListNode p = head;
	    	ListNode pn = p.next;
	    	ListNode lastEnd = pp;
	        while(i > 0){
	        	p = head;
	        	head = head.next;
	        	pn = p.next;
	        	pp = lastEnd;
	        	int swap = 0;
	        	while(swap < i){
		        	p.next = pn.next;
		        	pn.next = p;
		        	if(pp != null)
		        		pp.next = pn;
		        	pp = pn;
		        	pn= p.next;
		        	swap++;
	        	}
	        	i--;
	        }
	        if(idx++ == 0) firstGHead = head;
	        head = c.next;
	        pp = c;
		}
        return firstGHead;
    }
	
	public static ListNode reverseKGroup2(ListNode head, int k) {
		if(head == null || k == 1) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		int i = 0;
		while(head != null){
			i++;
			if(i % k ==0){
				pre = reverse(pre, head.next);
				head = pre.next;
			}else {
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	/**
	 * Reverse a link list between pre and next exclusively
	 * an example:
	 * a linked list:
	 * 0->1->2->3->4->5->6
	 * |           |   
	 * pre        next
	 * after call pre = reverse(pre, next)
	 * 
	 * 0->3->2->1->4->5->6
	 *          |  |
	 *          pre next
	 * @param pre 
	 * @param next
	 * @return the reversed list's last node, which is the precedence of parameter next
	 */
	private static ListNode reverse(ListNode pre, ListNode next){
		ListNode last = pre.next;//where first will be doomed "last"
		ListNode cur = last.next;
		while(cur != next){
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
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
