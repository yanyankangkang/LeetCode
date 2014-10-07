
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int row = search_row(matrix, target);
         if (row < 0 || row >= matrix.length){
        	 return false;
         }
    	 return search_col(matrix, target, row);
    }
    
    private int search_row(int[][] matrix, int target){
    	int l = 0, r = matrix.length - 1;
    	int mid = 0;
    	while(l <= r){
    		mid = (l + r) >> 1;  
    		if (matrix[mid][0] < target )
    			l  = mid + 1;
    		else if (matrix[mid][0] > target)
    			r = mid - 1;
    		else 
    			return mid;
    	}
    	return r;
    }
    private boolean search_col(int[][] matrix, int target, int row){
    	int l = 0, r = matrix[0].length - 1;
    	int mid;
    	while(l <= r){
    		mid = (l + r) >> 1; 
    		if(matrix[row][mid] < target){
    			l = mid + 1;
    		}
    		else if(matrix[row][mid] > target){
    			r = mid - 1;
    		}
    		else{
    			return true;
    		}
    	}
    	return false;
    }
    public static void main(String[] Agrs){
    	int [][] num = {
    	               {1}
    	};
    	Solution s = new Solution();
    	System.out.print(s.searchMatrix(num, 0));
    }
}
