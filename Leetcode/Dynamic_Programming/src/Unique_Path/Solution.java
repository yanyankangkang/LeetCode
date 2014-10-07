package Unique_Path;

public class Solution {
	public int uniquePaths(int m, int n) {
        int[][] d = new int [m + 1][n + 1];

        for(int i = 1; i <= m; i++){
        	for(int j = 1; j <= n; j++){
        		if (i == 1 && j == 1){
        			d[i][j] = 1;
        		}
        		else if (i == 1){
        			d[i][j] = d[i][j - 1];
        		}
        		else if(j == 1){
        			d[i][j] = d[i - 1][j];
        		}
        		else{
        			d[i][j] = d[i - 1][j] + d[i][j - 1];
        		}
        	}
        }
        return d[m][n];
    }
	
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	int m = obstacleGrid.length, n = obstacleGrid[0].length;
	int[][] d = new int [m + 1][n + 1];
    for(int i = 1; i <= m; i++){
    	for(int j = 1; j <= n; j++){
    		if (obstacleGrid[i - 1][j - 1] == 1){
    		   d[i][j] = 0;
    		   continue;
    		}
    		if (i == 1 && j == 1){
    			d[i][j] = 1;
    		}
    		else if (i == 1){
    			d[i][j] = d[i][j - 1];
    		}
    		else if(j == 1){
    			d[i][j] = d[i - 1][j];
    		}
    		else{
    			d[i][j] = d[i - 1][j] + d[i][j - 1];
    		}
    	}
    }
    return d[m][n];
    }
	public static void main(String[] Args ){
		Solution s = new Solution();
		int[][] num = {
		               {0,0,0},
		               {0,1,0},
		               {0,0,0}
	};
		System.out.print(s.uniquePathsWithObstacles(num));
	}
}
