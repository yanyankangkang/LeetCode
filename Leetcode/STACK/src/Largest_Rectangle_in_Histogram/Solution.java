package Largest_Rectangle_in_Histogram;
import java.util.*;
public class Solution {
	  public int largestRectangleArea(int[] height) {
		  if (height.length == 0)
			  return 0;
		  Stack<Integer> s = new Stack<Integer>();
		 
		  int length,Height;
		  s.push(0);
		  int Max = height[0];
		  for (int i = 1; i <= height.length; i++){          
			  int temp = (i == height.length ? -1 : height[i]); 
			  while (!s.empty() && height[s.peek()] > temp){
				Height = height[s.pop()]; 
			    length = s.empty() ? i : i - s.peek() - 1;
				Max = Math.max(Max, length * Height);
			  }
			  s.push(i);	
			 
		  }
		  return Max;
	    }
	  public static void main(String[] Args){
		  Solution s = new Solution();
		  int []num = {1, 1};
		  System.out.println(s.largestRectangleArea(num));
	  }
}
