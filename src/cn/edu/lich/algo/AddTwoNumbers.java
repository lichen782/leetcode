package cn.edu.lich.algo;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode ln1 = GenerateListNode(new int[]{2,4,3});
		ListNode ln2 = GenerateListNode(new int[]{5,6,4});
		ListNode result = addTwoNumbers(ln1,ln2);
		System.out.println(result);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = null;
		ListNode p = null;
		while(p1 != null && p2 != null) {
			int intRslt = p1.val + p2.val;
			if(p == null){
				p = head = new ListNode(intRslt);
			}else {
				int rmd = p.val % 10;
				int step = p.val / 10;
				p.val = rmd;
				p.next = new ListNode(intRslt + step);
				p = p.next;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		ListNode left = p1 == null ? p2 : p1;
		while(left != null){
			int rmd = p.val % 10;
			int step = p.val / 10;
			p.val = rmd;
			p.next = new ListNode(left.val + step);
			p = p.next;
			left = left.next;
		}
		if(p.val >= 10) {
			int rmd = p.val % 10;
			int step = p.val / 10;
			p.val = rmd;
			p.next = new ListNode(step);
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
	
	private static ListNode GenerateListNode(int[] array){
		ListNode head = null; 
		ListNode pre = head;
		for(int i = 0; i < array.length;i++) {
			ListNode ln = new ListNode(array[i]);
			if(pre == null) {
				head = pre = ln;
				continue;
			}
			pre.next = ln;
			pre = ln;
		}
		return head;
	}

}
