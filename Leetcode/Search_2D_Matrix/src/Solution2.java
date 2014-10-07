import java.util.*;
public class Solution2 {
	private int Min(int a, int b){
		return a <	 b ? a : b;
	}
	public boolean searchMatrix(int[][] matrix, int target, int nstart, int mstart, int n, int m) {
	     int start = 0;
	     int end = Min(m, n) - 1;
	     int mid;
	    // if (mstart >= m || nstart >= n)
    		// return false;

	    	 if (m == 1 && n==1){
	    		 System.out.println(nstart + " " + mstart);
	    	 return matrix[nstart][mstart] == target;
	    	 }
	    	 if (m == 1){
	    		 start = 0;
	    		 end = n - 1;
	    		 while (start + 1 < end){
	    	    	 mid = start + (end - start) / 2;
	    	    	 if (matrix[nstart + mid][mstart] == target)
	    	    		 return true;
	    	    	 else if (matrix[nstart + mid][mstart] < target){
	    	    		 start = mid;
	    	    	 }
	    	    	 else {
	    	    		 end = mid;
	    	    	 }
	    	     }
	    		 if (matrix[nstart + start][mstart] == target){
	    			 return true;
	    		 }
	    		 if (matrix[nstart + end][mstart] == target){
	    			 return true;
	    		 }
	    			return false; 
	    	 }
	    	 if (n == 1){
	    		 start = 0;
	    		 end = m - 1;
	    		 System.out.println(" " +  end);
	    		 while (start + 1 < end){
	    	    	 mid = start + (end - start) / 2;
	    	    	 if (matrix[nstart][mstart + mid] == target)
	    	    		 return true;
	    	    	 else if (matrix[nstart][mstart + mid] < target){
	    	    		 start = mid;
	    	    	 }
	    	    	 else {
	    	    		 end = mid;
	    	    	 }
	    	     
	    		 }
	    		
	    		 if (matrix[nstart][mstart + start] == target){
	    			 return true;
	    		 }
	    		 if (matrix[nstart][mstart + end] == target){
	    			 return true;
	    		 }
	    			return false; 
	    	 }

	     
	     while (start + 1 < end){
	    	 mid = start + (end - start) / 2;
	    	 if (matrix[nstart + mid][mstart + mid] == target)
	    		 return true;
	    	 else if (matrix[nstart + mid][mstart + mid] < target){
	    		 start = mid;
	    	 }
	    	 else {
	    		 end = mid;
	    	 }
	     }
	     if (matrix[nstart + start][mstart + start] == target){
			 return true;
		 }
		 if (matrix[nstart + end][mstart + end] == target){
			 return true;
		 }
		 System.out.println(start + " " + end + " " + nstart + " " + mstart + " " +n);
		 if (end == n - 1){
			 return searchMatrix(matrix, target, nstart , mstart + end , end, m - end );
		 }
		 else if(end == m - 1){
	   //  System.out.println(start + " " + end + " " + nstart + " " + mstart );
			 return searchMatrix(matrix, target, nstart + end, mstart, n - end, end);
		 }
		 else{
	     return (searchMatrix(matrix, target, nstart + end, mstart, n - end, end)||
	          searchMatrix(matrix, target, nstart , mstart + end , end, m - end ));
		 }
	
	}
	
	public static void main(String[] Args){
		int [][]num = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		
		int [][]num1 = {
				{-9,-8,-8,-8},
				{-7,-6,-5,-5},
				{-3,-1,0,0},
				{2,3,4,5},
				{7,7,7,7},
				{9,9,10,10}
		};
		int [][]num2 = {{-10,-9},{-7,-5},{-4,-3}};
		Solution2 s = new Solution2();
		System.out.print(s.searchMatrix(num, 50, 0, 0, 3, 4));
		//System.out.print(s.searchMatrix(num, 6, 0, 0, 4, 4));
	}
}
