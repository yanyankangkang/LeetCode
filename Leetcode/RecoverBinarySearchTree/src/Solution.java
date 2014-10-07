import java.util.*;
public class Solution {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 private void exchange(TreeNode node1, TreeNode node2){
		 int temp = node1.val;
		 node1.val = node2.val;
		 node2.val = temp;
	 }
	 private TreeNode last_node, first_hit, last_hit;  
	 /*******************************
	        if (last_node != null && last_node.val > val){
	        	exchange(last_node, root);
	        }
	        last_node = root;
	        *******************************/
	/* public void recoverTree(TreeNode root) {
	       
		 	if (root == null){
	        	return;
	        }
	        TreeNode left = root.left;
	        TreeNode right = root.right;
	        recoverTree(left);
	       
	        if (last_node != null && last_node.val > root.val){
	        	exchange(last_node, root);
	       //	 System.out.println("root " + root.val );
	 	     //   System.out.println(last_node.val);
	        }
	        last_node = root;
	        recoverTree(right);	
	        
	    }*/
	 public void recoverTree(TreeNode root) {
	       
		    
	        Recover(root);	
	        
	        if (last_hit != null){
	        	exchange(first_hit, last_hit);
	        }
	    }
	 
	 public void Recover(TreeNode root){
		 if (root == null){
	        	return;
	        }
	        TreeNode left = root.left;
	        TreeNode right = root.right;
	       
	         Recover(left);
	       
	        if (last_node != null && last_node.val > root.val){
	        	if(first_hit == null){
	        
	        		first_hit = last_node;
	        		last_hit = root;
	        	}
	        	else{
	        	
	        		last_hit = null;
	        		exchange(first_hit, root);
	        		return;
	        	}
	        }
	        last_node = root;
	        Recover(right);	
	      
	        
	 }
	 
	 public TreeNode BuildTree2(int[] num){
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
    public void Morris_tree(TreeNode root){
    	  TreeNode current = root;
    	  while (current != null){
    		  if (current.left != null){
    			  TreeNode it = current.left;
    			  while(it.right != null && it.right != current){
    				  it = it.right;
    			  }
    			  it.right = current;
    		  }
    		  else{
    			  current = current.right;
    		  }
    	  }
    	
    }
	public static void main(String[] Args){
		Solution s = new Solution();
		int[] num = {0, 1};
		TreeNode root = s.BuildTree2(num);
		s.recoverTree(root);
		ArrayList<Integer> result =new ArrayList<Integer>();
    	//System.out.println(root.val);
    	s.Preorder_Traverse(root, result);
    	for(Integer l:result){
    		System.out.println(l);
    	}

	}
}
