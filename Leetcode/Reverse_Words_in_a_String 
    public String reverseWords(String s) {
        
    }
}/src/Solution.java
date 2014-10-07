import java.util.*;
public class Solution {
	//give two numbers a,b and find the how many square of numbers meet requirements that between 
	//[a,b]. O(logn) 
	public int Square(int a, int b) {
		a = Math.max(0, a);
		b = Math.max(0, b);
		int l = (int) Math.sqrt(a), r = (int) (Math.sqrt(b) + 1);
	    int left = l;
		int res = 0;
       while(l + 1 < r){
    	   int mid = (l + r) >> 1;
       int num = mid * mid;
       if (num >=a && num <=b ){
    	   l = mid;
       	}
       else if (num < a){
    	   l = mid;
       	}
       else if (num > b){
    	   r = mid;
       }
      }
       if (r * r >= a && r * r <=b){
    	   res = r;
       }
       else if (l * l >=a && r * r <=b){
    	   res = l;
       }
       else{
    	   res = -1;
       }
       if (res != -1){
    	   res -= left;
    	   if (left * left == a){
    		   res += 1;
    	   }
       }
       return res;
    }
	//find the largest gap in unsorted array, gap is defined as smallest distance between elements in array
	//and another number T which T is between min(array) and max(array)
	public int solution(int[] A) {
		int MAX = Integer.MIN_VALUE;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++){
        	MAX = Math.max((A[i] + A[i - 1]) / 2, MAX);
        }
        return MAX;
    }
	public static void main(String[] Args){
		
	}
}
