import java.util.*;
public class Solution {
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        Queue<TreeNode> q= new LinkedList<TreeNode>();
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        boolean reverse = false;
		 	int size;
		 	int start, end;
	        q.offer(root);
	        while(!q.isEmpty()){
		 		size = q.size();
		 		ArrayList<Integer> current = new ArrayList<Integer>();
		 		int[] num = new int[size];
		 		for(int i = 0 ;i < size; i++){
		 			TreeNode node = q.poll();
		 			num[i] = node.val;
		 			if (node.left != null){
		 			q.offer(node.left);
		 			}
		 			if (node.right != null){
		 			q.offer(node.right);
		 			}
		 		}
		 		if (!reverse){
		 			for(int i = 0; i < size; i++){
			 			current.add(num[i]);
			 		}
		 		}
		 		else{
		 			for(int i = size - 1; i >=0; i--){
			 			current.add(num[i]);
			 		}
		 		}
		 		result.add(current);
		 		reverse = !reverse;
		 	}
		 return result;
	    }
}
