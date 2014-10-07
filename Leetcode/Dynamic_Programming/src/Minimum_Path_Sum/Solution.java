package Minimum_Path_Sum;

public class Solution {
	private int Min(int a, int b){
		return a < b ? a : b;
	}
public int minPathSum(int[][] grid) {
        int  n = grid.length, m = grid[0].length;
        int [][] d = new int [n + 1][m + 1];
    
        for(int i = 1; i <= n; i++){
        	for(int j = 1; j <= m; j++){
        		if (i == 1){
        			d[i][j] = d[i][j - 1] ;
        		}
        		else if (j == 1){
        			d[i][j] = d[i - 1][j];
        		}
        		else{
        		d[i][j] = Min(d[i - 1][j], d[i][j - 1]) ;
        		}
        	d[i][j]	+= grid[i - 1][j - 1];
        	}
        }
        return d[n][m];
    }
   public static void main(String [] Args){
	   Solution s = new Solution();
	   int [][] grid = {
			   {9, 1, 4, 8}
	   };
	   System.out.print(s.minPathSum(grid));
   }
}
