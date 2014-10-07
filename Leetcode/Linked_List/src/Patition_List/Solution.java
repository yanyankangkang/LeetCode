package Patition_List;

import Elementary.Link;
import Elementary.Link.ListNode;

public class Solution {
	 public ListNode partition(ListNode head, int x) {
		 if (head == null){
			 return null;
		 }
	        ListNode left = null, right = null;
	        ListNode left_head = null, right_head = null;
	        while (head != null){
	        	if (head.val < x){
	        		if (left_head == null){
	        			left_head = new ListNode(head.val);
	        			left = left_head;
	        		}
	        		else{
	        			left.next = new ListNode(head.val);
	        			left = left.next;
	        		}
	        	}
	        	else{
	        		if (right_head == null){
	        			right_head = new ListNode(head.val);
	        			right = right_head;
	        		}
	        		else{
	        			right.next = new ListNode(head.val);
	        		    right = right.next;
	        		}
	        	}
	        	head = head.next;
	        }
	        if (left != null){
	        left.next = right_head;
	        if (right != null)
	        right.next = null;
	        return left_head;
	        }
	        else
	        	return right_head;
	    }
	 public static void main(String[] Args){
		 Solution s = new Solution();
		 Link l = new Link();
		 int [] num = {1};
		 ListNode head = l.ListNode_create(num);
		 head = s.partition(head, 2);
		 l.ListPrint(head);
	 }
	 
}
