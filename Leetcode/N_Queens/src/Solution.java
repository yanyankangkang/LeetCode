import java.util.*;
public class Solution {  //这题做过，但是很多细节问题都忘了，结果还是用了很长的时间 !!!
	 ArrayList<String[]> res;
	 boolean [] vis_col;
	 boolean [] vis_row;
	 public List<String[]> solveNQueens(int n) {
	        res = new ArrayList<String[]> ();
	        vis_col = new boolean[n + 2];
	        vis_row = new boolean[n + 2];
	        String[] board = new String[n];
	        for (int i = 0; i < n ; i++){
	        	board[i] = "";
	        	for (int j = 0; j < n ; j++){
	        		board[i] += "."; 
	        	}
	        }
	        NQueens( n, 1, board);
	        return res;
	 }
	 
	 public boolean judge(int i, int j, int n, String[] board){
		 if (vis_col[i] || vis_row[j]){                 //判断在同一条横线或竖线上
			 return false;
		 }
		 for (int k = 1; k < n; k++){                   //判断对角线，不能用vis_col和vis_row判断，因为很容易不在一个点却又满足
			 if (i - k > 0 && j - k > 0){
				 if ((board[j - k - 1].charAt(i - k - 1) == 'Q')){
					 return false;
				 }
			 }
			 else 
				 break;
		 } 
		 for (int k = 1; k < n; k++){               //同上
			 if (i + k <= n && j - k > 0){
				 if (board[j - k - 1].charAt(i + k - 1) == 'Q'){	
				 return false;
				 }
			 }
			 else 
				 break;
		 }
		 return true;		 
	 }
	 public void NQueens(int n, int k, String[] board){
		/* for(int i = 0; i < board.length; i++){
			 System.out.println(board[i]);
		 }
		 System.out.print("\n");*/
		 if (k == n + 1){
			//System.out.println(i +  " " +vis_col[i] + " " + j + " " + vis_row[j]);
			
			res.add(board.clone());   //这步实在太tricky了，一定要复制新的
			return;
		 }
		 for (int i = 1; i <= n; i++){
			
			 if (judge(i, k, n, board)){
				 vis_col[i] = true;
				 vis_row[k] = true;
				 board[k - 1] = board[k - 1].substring(0, i - 1) + 'Q' + board[k - 1].substring(i, n); //用来代替循环构造字符串或许有更好的做法
				// System.out.println(board[k - 1]);
				 NQueens(n, k + 1, board);
				 board[k - 1] = board[k - 1].substring(0, i - 1) + '.' + board[k - 1].substring(i, n);
				 vis_col[i] = false;
				 vis_row[k] = false;
			 }
			 else{
				
			 }
		 }
	 }
	 public static void main(String[] Args){
		 Solution s = new Solution();
		 List<String[]> res = s.solveNQueens(0);
		 for (String[] l : res){
			 for(int i = 0; i < l.length; i++){
				 System.out.println(l[i]);
			 }
			 System.out.print("\n");
		 }
	 }
}
