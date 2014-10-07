import java.util.*;
public class Solution {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public TreeNode BuildTree(int[] num, int index){
		if (index > num.length || num[index - 1] == '#') {
			return null;
		}
		TreeNode root = new TreeNode(num[index - 1]);
		System.out.println(num[index - 1]);
		root.left = BuildTree(num, index * 2 );
		root.right = BuildTree(num, index * 2 + 1 );
		return root;
	}
	public TreeNode BuildTree2(int[] num, int index){
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<TreeNode> parent = new LinkedList<TreeNode>();
		if (num.length == 0)
			return null;
		for (int i = 1; i < num.length; i++){
			q.offer(num[i]);
		}
		TreeNode root = new TreeNode(num[0]);
		parent.offer(root);
		while(!q.isEmpty()){
			int size = parent.size();
			Queue<TreeNode> current = new LinkedList<TreeNode>();
			for(int i = 0; i< size; i++){
			   TreeNode node = parent.poll(); 
			   if (q.isEmpty())
				   break;
			   int val = q.poll();
			   if (val != '#'){
				   node.left = new TreeNode(val);
				   current.offer(node.left);
			   }
			   else{
				   node.left = null;
			   }
			   if (q.isEmpty()){
				   break;
			   }
			   val = q.poll();
			   if (val != '#'){
				   node.right = new TreeNode(val);
				   current.offer(node.right);
			   }
			   else{
				   node.right = null;
			   }
			}
			parent = current;
		}
			return root;
	}
    public void Preorder_Traverse(TreeNode root, ArrayList<Integer> result){
    	if (root == null){
    		return;
    	}
    	result.add(root.val);
    	Preorder_Traverse(root.left, result);
    	Preorder_Traverse(root.right, result);
    	return;
    }
        public boolean isValidBST(TreeNode root) {
        	    return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE); 
        }
        public boolean helper(TreeNode root, int Max, int Min) {
        	if (root == null){
        		return true;
        	}
        	if (root.val > Max || root.val < Min){
        		return false;
        	}
        	return helper(root.left, root.val - 1, Min) && helper(root.right, Max, root.val + 1);        	
        }
    public static void main(String[] Args){
    	int[] num = {0, -1};
    	Solution s = new Solution();
    	ArrayList<Integer> result =new ArrayList<Integer>();
    	TreeNode root = s.BuildTree2(num, 1);
    	System.out.println(s.isValidBST(root));
    	/*s.Preorder_Traverse(root, result);
    	for(Integer l:result){
    		System.out.println(l);
    	}*/
    }
}
