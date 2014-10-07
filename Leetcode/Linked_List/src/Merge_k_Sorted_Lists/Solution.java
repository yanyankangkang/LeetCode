package Merge_k_Sorted_Lists;
import java.util.*;

import Elementary.Link;
import Elementary.Link.ListNode;
public class Solution {
	private Comparator<ListNode> ListNode_comparator =  new Comparator<ListNode>(){  
        public int compare(ListNode l1, ListNode l2) {  
            // TODO Auto-generated method stub  
            return l1.val - l2.val;
        }  
	};
	 public ListNode mergeKLists(List<ListNode> lists) {
		  if ( lists == null || lists.size() == 0){
			  return null;
		  }
	      int N = 0;
	      ListNode dummynode = new ListNode(0);
	      ListNode pos = dummynode;
	      ListNode cur;
	      Queue <ListNode> priority = new PriorityQueue<ListNode>(lists.size(), ListNode_comparator);
	      for (ListNode head : lists){
	    	  if (head != null)
	    	  priority.offer(head);
	      }
	      if (priority.isEmpty())   //易错点
	    	  return null;
	      while(true){
	    	  do{
	    	  cur = priority.poll();
	    	  pos.next = cur;
	    	  pos = cur;
	    	  }while(cur.next == null && !priority.isEmpty());
	    	  if (priority.isEmpty() && cur.next == null){
	    		  pos.next = null;
	    		  return dummynode.next;
	    	  }
	    	  priority.offer(cur.next);    
	    }
	 }
	 
	 public static void main(String [] Args){
		 Solution s = new Solution();
		 Link l = new Link();
		 ListNode head;
		 ArrayList<ListNode> lists = new ArrayList<ListNode>();
		 int[] num1 = {};
		 int[] num2 = {};
		 int[] num3 = {};
 		 head = l.ListNode_create(num1);
		 lists.add(head);
		 head = l.ListNode_create(num2);
		 lists.add(head);
		 head = l.ListNode_create(num3);
		 lists.add(head);
		 head = s.mergeKLists(lists);
		 l.ListPrint(head);
	 }
	 
}
