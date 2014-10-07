
public class Solution2 {
	  public int search(int[] A, int target) {
	     int start, end, mid;
	     int N = A.length;
	     start = 0;
	     end = N - 1;
	     while(start + 1 < end){
	    	 mid = start + (end - start) / 2;
	    	 if (A[mid] == target){
	    		 return mid;
	    	 }
	    	 if (A[mid] > A[start]){
		    	 if (A[start] <= target && A[mid] > target){
		    		 end = mid;
		    	 }
		    	 else{
		    		 start = mid;
		    	 }
		    //	 System.out.print("mid1 =" + mid + "\n");
		   // 	 System.out.println("s1 =" + start + ", e1 =" + end);
	    	 }
	    	 else {//if (A[mid] < A[start]){
		    	 if (target <= A[end] && A[mid] < target){
		    		 start = mid;
		    	 }
		    	 else{
		    		 end = mid;
		    	 }
		       //  System.out.print("mid2 =" + mid + "\n");
		    //	 System.out.println("s2 =" + start + ", e2 =" + end);
	    	 }
	    	// else{
	    //		 start++;
	    	// }
	         
	     }
	     if (A[start] == target){
	    	 return start;
	     }
	     else if (A[end] == target){
	    	 return end;
	     }
	     else{
	    	 return -1;
	     }
	    }
	  public static void main(String[] Args){
		  Solution2 s = new Solution2();
		  int[] num = { 1, 1, 3, 1};
		  System.out.print(s.search(num, 3));
	  }
}
