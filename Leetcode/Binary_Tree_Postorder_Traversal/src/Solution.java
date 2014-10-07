import java.util.*;
public class Solution {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        Stack<TreeNode> reverse_result = new Stack<TreeNode>();
	        s.push(root);
	        reverse_result.push(root);
	       	    while(!s.empty()){
	        	TreeNode node = s.pop();
	        	if (node.left != null){
	        		s.push(node.left);
	        	}
	        	if (node.right != null){
	        		s.push(node.right);
	        	}
	        	
	        }
	    }
}
