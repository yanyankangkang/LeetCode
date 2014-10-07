import java.util.*;
public class Solution1 {
	public boolean searchMatrix(int[][] matrix, int target) {
      /* int n = matrix.length;
       int m = matrix[0].length;
		int i = n;
       int j = 1;
       while(i > 0 && j <= matrix[0].length){
    	   for(; i > 0; i--){
    		   if (matrix[i - 1][j - 1] == target){
    			   return true;
    		   }
    		   else if(matrix[i - 1][j - 1] < target){
    			   break;
    		   }
    	   }
    	   if (i <= 0){
    		   return false;
    	   }
    	   for(; j <= m; j++){
    		   if (matrix[i - 1][j - 1] == target){
    			   return true;
    		   }
    		   else if(matrix[i - 1][j - 1] > target){
    			   break;
    		   }
    	   }
       }
       return false;*/
	return searchMatrix1(matrix, target, 0, 0, matrix.length, matrix[0].length);
   }
	private int Min(int a, int b){
		return a < b ? a : b;
	}
	private boolean binarySearch(int[][] matrix, int target, int nstart, int mstart, int n, int m){
		int start, end, mid;
		if (n == 1 && m == 1 ){
			return matrix[nstart][mstart] == target;
		}
		if (n == 1){
			start = 0;
			end = m - 1;
			while(start + 1 < end){
				mid = (start + end) >> 1;
				if (matrix[nstart][mstart + mid] == target)
					return true;
				else if(matrix[nstart][mstart + mid] < target){
					start = mid;
				}
				else{
					end = mid;
				}
			}
			if (matrix[nstart][mstart + start] == target)
				return true;
			else if (matrix[nstart][mstart + end] == target){
				return true;
			}
			else 
				return false;
		}
		if (m == 1){
			start = 0;
			end = n - 1;
			while(start + 1 < end){
				mid = (start + end) >> 1;
				if (matrix[nstart + mid][mstart] == target)
					return true;
				else if(matrix[nstart + mid][mstart] < target){
					start = mid;
				}
				else{
					end = mid;
				}
			}
			if (matrix[nstart + start][mstart] == target)
				return true;
			else if (matrix[nstart + end][mstart] == target){
				return true;
			}
			else 
				return false;
		}
		return false;
	}
	public boolean searchMatrix1(int[][] matrix, int target, int nstart, int mstart, int n, int m){
		
		  if(n == 1 || m == 1){
			  return binarySearch(matrix, target, nstart, mstart, n, m);
		  }
		  int start = 0;
		  int end = Min(m, n) - 1;  
		  int mid;	
		  while (start <= end){
			  mid = start + (end - start) / 2;
			  if (matrix[nstart + mid][mstart + mid] == target){
				  return true;
			  }
			  else if (matrix[nstart + mid][mstart + mid] < target){
				  return (searchMatrix1(matrix, target, nstart + mid + 1, mstart, n - mid - 1, mid + 1) ||
						  searchMatrix1(matrix, target, nstart + mid + 1, mstart + mid + 1, n - mid - 1, m - mid - 1) ||
						  searchMatrix1(matrix, target, nstart , mstart + mid + 1, mid + 1, m - mid - 1));
			  }
			  else{
				  end = mid - 1;
			  }
		  }
		  return false;
	}
	
	public static void main(String[] Args){
		int [][]num = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		int[][] num1 = {
				{-9,-8,-8},
				{-5,-3,-2},
				{0,2,2},
				{4,6,8}
		};
		int [][] num2 = {
				{1, 1},
				{2, 2}
		};
		Solution1 s = new Solution1();
		System.out.print(s.searchMatrix(num2, 0));
	}
}
