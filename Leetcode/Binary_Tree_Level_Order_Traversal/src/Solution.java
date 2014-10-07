import java.util.*;
public class Solution {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        int tree_level, last_level;
        ArrayList<ArrayList<Integer>> list = new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        if (root == null)
        	return list;
        q.offer(root);
        level.offer(0);
        last_level = 0;
        while(!q.isEmpty()){
        	tree_level = level.poll();
        	TreeNode node = q.poll();
        	if (tree_level == last_level + 1){
        		list.add(current);
        		current = new ArrayList<Integer>();
        	}
        	current.add(node.val);
        	if (node.left != null){
        		q.offer(node.left);
        		level.offer(tree_level + 1);
        	}
        	if (node.right != null){
        		q.offer(node.right);
        		level.offer(tree_level + 1);
        	}
        	last_level = tree_level;
        }
        if (!current.isEmpty()){
        	list.add(current);
        }
        return list;
    }

}
