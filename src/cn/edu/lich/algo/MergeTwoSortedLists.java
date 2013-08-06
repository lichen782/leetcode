package cn.edu.lich.algo;

public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(7);
		l1.next.next.next = new ListNode(12);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(15);
		
		System.out.println("l1: " + l1);
		System.out.println("l2: " + l2);
		
		System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
	}
	
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode tail, head = null;
        if(l1 != null && l2 != null){
        	if(l1.val < l2.val) {
        		head = l1;
        		l1 = l1.next;
        	}else {
        		head = l2;
        		l2 = l2.next;
        	}
        	head.next = null;
        }else {
        	return l1 != null ? l1 : l2;
        }
        tail = head;
        while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		tail.next = l1;
        		l1 = l1.next;
        	}else {
        		tail.next = l2;
        		l2 = l2.next;
        	}
        	tail = tail.next;
        	tail.next = null;
        }
        tail.next = l1 != null ? l1 : l2;
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
			sb.append(val + " ");
			ListNode p = next;
			while(p!= null) {
				sb.append(p.val + " ");
				p = p.next;
			}
			return sb.toString();
		}
    }

}
