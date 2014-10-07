package Elementary;

import Remove_Duplicates_from_Sorted_List_II.Solution.ListNode;

public class Link {
	public static class ListNode {
	     public int val;
	     public ListNode next;
	    public ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	 public ListNode ListNode_create(int[] num){
		 if (num.length == 0){
			 return null;
		 }
		 ListNode current = new ListNode(num[0]);
		 ListNode head = current;
		 for (int i = 1; i < num.length; i++){
			 ListNode temp = new ListNode(num[i]);
			 current.next = temp;
			 current = temp;
		 }
		 return head;
	 }
	 public void ListPrint(ListNode head){
		 while (head != null){
			 System.out.print(head.val + " ");
			 head = head.next;
		 }
	 }
	 public static void main(String[] Args){
		 Link l = new Link();
		 int [] num = {1,2,3,4,5};
		 ListNode  head = l.ListNode_create(num);
		 l.ListPrint(head);
	 }
}
