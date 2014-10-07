package Triangle;

import java.util.*;;

public class Solution {
	private int Min(int a, int b){
		return a < b ? a : b;
	}
	 public int minimumTotal(List<List<Integer>> triangle) {
	        int [][] minsum = new int [2][triangle.size() + 1];
	        int [] arrayl = new int [triangle.size() + 1];
	        int row = 0;
	        for(int i = 1; i <= triangle.size(); i++){
	        	row = (row + 1) % 2;
	        	List<Integer> temp = triangle.get(i - 1);
	        	int c = 0;
	        	for (Integer j : temp){
	        		arrayl[++c] = j;
	        	}
	        	for (int j = 1; j <= i; j++){
	        		if (j == 1){
	        			minsum[row][j] = minsum[(row + 1) % 2][j];
	        		}
	        		else if (j == i){
	        			minsum[row][j] = minsum[(row + 1) % 2][j - 1];
	        		}
	        		else{
	        			minsum[row][j] = Min(minsum[(row + 1) % 2][j - 1], minsum[(row + 1) % 2][j]);
	        		}
	        		minsum[row][j] += arrayl[j];
	        	}
	        }
	       
	        int MINSUM = minsum[row][1];
	        for(int i = 2; i <= triangle.size(); i++){
	        	
	        		MINSUM = Min(MINSUM, minsum[row][i]);
	        	
	       // 	System.out.print(minsum[row][i] + " ");
	        }
	        return MINSUM;
	    }
	 
	 public static void main(String[] Args){
		 int [][] num ={
		     {1},
		    {2,3}
		   };
		 List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		 for (int i = 0; i < num.length; i++){
			 ArrayList<Integer> temp = new ArrayList<Integer>();
			 for (int j = 0; j <= i ; j++){
				 temp.add(num[i][j]);
			 }
			triangle.add(temp);	 
		 }
		  Solution s = new Solution();
		 // System.out.println(triangle.size());
		 System.out.print(s.minimumTotal(triangle));
	 }
}
