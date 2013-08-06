package cn.edu.lich.algo;

import java.util.ArrayList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author lich
 *
 */
public class MergeSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		//lists.add(null);
		lists.add(new ListNode(1));
		ListNode head = mergeKLists(lists);
		
		System.out.println(head);
	}
	
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ListNode head = null;
		int minValue = Integer.MAX_VALUE;
		int minIdx = -1;
		for(int i = 0; i < lists.size();i++){
			if(lists.get(i) != null && lists.get(i).val < minValue){
				head = lists.get(i);
				minValue = lists.get(i).val;
				minIdx = i;
			}
		}
		if(head != null){
			lists.set(minIdx, head.next);
			ListNode tail = head;
			merge(tail, lists);
		}
		return head;
    }
	
	private static void merge(ListNode tail, ArrayList<ListNode> lists){
		while(true){
			int minValue = Integer.MAX_VALUE;
			ListNode minNode = null;
			int minIdx = -1;
			for(int i = 0; i < lists.size();i++){
				if(lists.get(i) != null && lists.get(i).val < minValue){
					minNode = lists.get(i);
					minValue = lists.get(i).val;
					minIdx = i;
				}
			}
			if(tail == null){
				tail = minNode;
			}
			else {
				tail.next = minNode;
				tail = minNode;
			}
			if(minNode != null) {
				lists.set(minIdx, minNode.next);
				minNode = minNode.next;
			}else break;
		}
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
