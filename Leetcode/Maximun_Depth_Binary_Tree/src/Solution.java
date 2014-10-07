
public class Solution {
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	 private  int max_depth(int a, int b){
		 if(a > b)
			  return a;
		 else 
			 return b;
	 }
	 public int maxDepth(TreeNode root) {
	        if (root == null){
	        	return 0;
	        }
	        return max_depth(maxDepth(root.left), maxDepth(root.right)) + 1;
	    }
	 
}
