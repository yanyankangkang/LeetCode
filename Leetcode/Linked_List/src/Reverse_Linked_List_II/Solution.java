package Reverse_Linked_List_II;


import Elementary.Link;
import Elementary.Link.ListNode;

public class Solution {
	
	public ListNode Find_Kth_element (ListNode head, int k){
		int count = 1;
		if (k < 1){
			return null;
		}
		while(count < k){
			count++ ;
			head = head.next;
		}
		//System.out.println(head.val);
		return head;
	}
	
	public ListNode reverseBetween (ListNode head, int m, int n) {
		ListNode dummynode = new ListNode(0);
		dummynode.next = head;
		ListNode start =  Find_Kth_element(head, m - 1);
		ListNode end =  Find_Kth_element(head, n + 1);
		ListNode pre, cur, temp;
		if (start == null)
			start = dummynode;
		cur = start.next;
		pre = end;
		while (cur != end){
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		start.next = pre;
	//	System.out.println(start.val);
		return dummynode.next;
    }	
	
	public static void main(String[] Args){
		int[] num = {3, 5};
	    Link l = new Link();
	    Solution s = new Solution();
	    ListNode head = l.ListNode_create(num);
	    l.ListPrint(s.reverseBetween(head, 1, 2));
	}
}
