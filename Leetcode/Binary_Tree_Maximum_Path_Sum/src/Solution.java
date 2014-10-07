
public class Solution {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private int max_sum(int a, int b){
		if(a > b){
			return a;
		}
		else {
			return b;
		}
	}
	private int maxSum = 0;
	public int maxPathSum(TreeNode root) {
       int ans = maxpathsum(root);
       if (root == null)
          return 0;
       if (ans > root.val)
         ans = root.val;
         return ans;
    }
    private int maxpathsum(TreeNode root){
         if (root == null){
        	return 0;
        }
        int left_sum, right_sum, sum;
        left_sum = maxPathSum(root.left);
        right_sum = maxPathSum(root.right);
        sum = max_sum(left_sum, right_sum);
        if (sum + root.val <= 0)
        	return 0;
        else{
        	maxSum = max_sum(sum + root.val, maxSum);
            return sum + root.val;
        }
    }
    public static void main(String [] Args){
    	Solution s = new Solution();
    	
    }
}
