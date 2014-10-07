package Remove_Duplicates_from_Sorted_List_II;

public class Solution {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		    	  val = x;
		          next = null;
		      }
		  }
	 public ListNode deleteDuplicates(ListNode head) {
	        ListNode dummynode = new ListNode(0);  
	        dummynode.next = head;         //设置哨兵节点，为了索引后面节点，因为head一直在变化
	        head = dummynode;
	        while (head.next != null && head.next.next != null){
	        	if (head.next.val == head.next.next.val){                  //一旦找到第一次前后相同，则同第一个开始把所有和val相同的节点删去
	        		int val = head.next.val;
	        		while (head.next != null && val == head.next.val ){
	        			head.next = head.next.next;
	        			//head = head.next;             // 这句不能加因为当前节点删除相当于往后移位
	        		}
	        	}
	        	else{
	        		head = head.next;
	        	}
	        }
	        return dummynode.next;
	    }
	 public ListNode ListNode_create(int[] num){
		 ListNode head = null;
		 for (int i = 0; i < num.length; i++){
			 ListNode temp = new ListNode(num[i]);
			 temp.next = head;
			 head = temp;
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
		 int[] num = {3,2,1,1,1};
		 Solution s= new Solution();
		 ListNode head = s.ListNode_create(num);
		 ListNode res = s.deleteDuplicates(head);
		 s.ListPrint(res);
	 }
}
