package Reverse_Nodes_in_kGroup;
import Elementary.Link;
import Elementary.Link.ListNode;
public class Solution {
	 public ListNode reverse(ListNode head, int k){
		 ListNode prev, cur, temp;
		 prev = null;
		 cur = head;
		 while(k > 0){
			 temp = cur.next;
			 cur.next = prev;
			 prev = cur;
			 cur = temp;
			 k--;
		 }
		 head.next = null;
		 return prev;
	 }
	 
	 public ListNode findKth(ListNode head, int k){
		 for (int i = 0; i < k - 1; i++){
			 if(head != null){
				 head = head.next;
			 }
			 else{
				 return null;
			 }
		 }
		 return head;
	 }
	 public ListNode reverseKGroup(ListNode head, int k){
		 ListNode nextHead = findKth(head, k);
		 if (nextHead == null){
			 return head; 
		 }
		 ListNode temp = nextHead.next; 
		 ListNode subHead = reverse(head, k);
		 head.next = reverseKGroup(temp, k);
		 return subHead;
	 }
	 public static void main(String[] Args){
		 Link.ListNode head;
		 Link L = new Link();
		 int [] num = {1,2,3};
		 head = L.ListNode_create(num);
		 Solution s = new Solution();
		 head = s.reverseKGroup(head, 3);
		 L.ListPrint(head);
	 }
}
