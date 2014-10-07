import java.util.*;
public class Solution {
	 public boolean search(int[] A, int target) {
	        int l = 0, r = A.length - 1;
	        int mid; 
	        //Arrays.sort(A);
	        while(l <= r ){
	            mid = (l + r) >> 1;
	            if(target > A[mid]){
	                l = mid + 1;
	            }
	            else if (A[target] < A[mid]){
	                r = mid - 1;
	            }
	            else
	                return true;
	        }
	        return false;
	    }
	 public static void main(String [] Args){
		 int [] num = {1, 1};
		 Solution s = new Solution();
		 System.out.print(s.search(num, 2));
	 }
}
