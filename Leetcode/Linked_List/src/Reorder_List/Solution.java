package Reorder_List;

import Elementary.Link;
import Elementary.Link.ListNode;

public class Solution {
	public ListNode findMid(ListNode head){
	ListNode dummynode = new ListNode(0);
	dummynode.next = head;
	ListNode faster = dummynode, lower = dummynode;
	while(faster.next != null && faster.next.next != null){
		faster = faster.next.next;
		lower = lower.next;
	}
	return lower;
}
	
	
	public ListNode reverse (ListNode head) {
		ListNode dummynode = new ListNode(0);
		dummynode.next = head;
		ListNode start =  null;
		ListNode end =  null;
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
	
	public ListNode Merge2List(ListNode left, ListNode right){
		ListNode dummynode = new ListNode(0);
		if (left == right)
			right = null;
		dummynode.next = left;
		ListNode head = dummynode;
		//System.out.println("Right" + right.val);
		while(left != null || right != null){
			//System.out.println(left.val + " " + right.val);
			if (left != null){
			head.next = left;
			head = left;
		//	System.out.println("Left" + left.val);
			left = left.next;
	
			}
			if (right != null){
			head.next = right;
			head = right;	
			right = right.next;
			
			}
			
		}
		return dummynode.next;
	}
    public ListNode reorderList(ListNode head) {
        if (head == null)
        	return null;
    	ListNode mid = findMid(head);
    	ListNode left = head, right = mid.next;
    	if (mid.next.next != null){           //当只剩一个元素时，易错点
    	right = reverse(mid.next);
    	} 
   // 	Link l = new Link();
    //	l.ListPrint(left);
    	mid.next = null;
    	ListNode res = Merge2List(left, right);    
    	return res;
    	
    }
    
    public static void main(String[] Args){
    	Solution s = new Solution();
    	Link l = new Link();
    	int [] num = {1, 2, 3, 4};
    	ListNode head = l.ListNode_create(num);
    	head = s.reorderList(head);
    	l.ListPrint(head);
    }
}
