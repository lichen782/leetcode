package cn.edu.lich.algo;

public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(head);
		System.out.println(new RotateList().rotateRight(head, 2));
	}
	
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ListNode p = head;
    	int length = 0;
    	while(p != null){
    		p = p.next;
    		length++;
    	}
    	if(length == 0) return head;
        ListNode slow = head;
        ListNode fast = head;
        n %= length;
        int k = 0;
        while(k < n){
        	fast = fast.next;
        	k++;
        }
        while(fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
    
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
       val = x;
       next = null;
       }
       @Override
       public String toString() {
    	   return Integer.toString(val) + (next == null ? "" : "->" + next);
       }
    }

}
