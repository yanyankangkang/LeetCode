import java.util.*;
public class Solution {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 public TreeNode BuildTree(int[] num){
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
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if ( root == null){
            return res;
        }
        s.push(root);
        while(!s.empty()){
            TreeNode temp = s.pop();
        	TreeNode parent = new TreeNode( temp.val);
            parent.left = temp.left;
        	parent.right = temp.right;
        	res.add(parent.val);

        	if ( parent.right != null ){
        		s.push(parent.right);
        	}
            if ( parent.left != null ){
        		s.push(parent.left);
        	}
        		
        }
        return res;
    }
	
	public ArrayList<Integer> inorderTraversal(TreeNode root){
		 Stack<TreeNode> s = new Stack<TreeNode>();
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        if ( root == null){
	            return res;
	        }
	        TreeNode node = new TreeNode( root.val);
	        node.left = null;
	        node.right = root.right;
	        s.push(node);
	        node = root;
	        while(!s.empty()){
	        	if ( node.left != null ){
	        		node = node.left;
	        		TreeNode parent = new TreeNode(node.val);
		            parent.left = null;
		        	parent.right = node.right;
		        	s.push(parent);
		        }
	        	else{
	        		node = s.pop();
	        		res.add(node.val);
	        		if (node.right != null){
	        			node = node.right;
		        		TreeNode parent = new TreeNode( node.val);
			            parent.left = null;
			        	parent.right = node.right;
			        	s.push(parent);
	        		}
	        	}  
	        		
	        }
	        return res;
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		 Stack<TreeNode> s = new Stack<TreeNode>();
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        if ( root == null){
	            return res;
	        }
	        TreeNode node = new TreeNode( root.val);
	        node.left = null;
	        node.right = root.right;
	        s.push(node);
	        node = root;
	        while(!s.empty()){
	        	if ( node.left != null ){
	        		node = node.left;
	        		TreeNode parent = new TreeNode(node.val);
		            parent.left = null;
		        	parent.right = node.right;
		        	s.push(parent);
		        }
	        	else{
	        		node = s.pop();
	        		if (node.right != null){	
	        			TreeNode temp_node = new TreeNode(node.val);
	        			temp_node.left = null;
	        			temp_node.right = null;
	        			s.push(temp_node);
	        			node = node.right;
		        		TreeNode parent = new TreeNode(node.val);
			            parent.left = null;
			        	parent.right = node.right;
			        	s.push(parent);
	        		}
	        		else{	
		        		res.add(node.val);
	        		}
	        	}  
	        		
	        }
	        return res;
	}
    public static void main(String[] Args){
    	Solution s = new Solution();
    	int[] num = {1, 2, 3, 4, 5};
    	TreeNode root = s.BuildTree(num);
    	ArrayList<Integer> res = s.postorderTraversal(root);
    	for (Integer l: res){
    		System.out.print(l + " ");
    	}
    }
}
