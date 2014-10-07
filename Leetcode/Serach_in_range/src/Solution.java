
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int l, r;
        int [] Default = {-1, - 1};
        l = search_left(A, target);
        if (l < 0 || A[l] != target ){
        	return Default ;
        }
        r = search_right(A, target);
        if (r >= A.length || A[r] != target){
        	return Default;
        }
        Default[0] = l;
        Default[1] = r;
        return Default;
    }
    
    private int search_left(int[] A, int target){
    	int l = 0, r = A.length - 1;
    	int mid;
    	while(l <= r){
    		mid = (l + r) >> 1;
    	    if (A[mid] < target ){
    	    	l = mid + 1;
    	    }
    	    else if(A[mid] > target){
    	    	r = mid - 1;
    	    }
    	    else{
    	    	if(mid == 0 || A[mid - 1] != target){
    	    		
    	    		return mid;
    	    	}
    	    	else{	
    	    	 r = mid - 1;
    	        }
    	    }
    	}
    	//System.out.println(r);
    	return r;
    }
    private int search_right(int[] A, int target){
    	int l = 0, r = A.length - 1;
    	int mid;
    	while(l <= r){
    		mid = (l + r) >> 1;
    	    if (A[mid] < target ){
    	    	l = mid + 1;
    	    }
    	    else if(A[mid] > target){
    	    	r = mid - 1;
    	    }
    	    else{
    	    	if(mid == A.length - 1 || A[mid + 1] != target){
    	    		return mid;
    	    	}
    	    	else{	
    	    	 l = mid + 1;
    	        }
    	    }
    	}
    	return l;
    }
   public static void main(String [] Args){
	   Solution s = new Solution();
	   int[] num = {5,6,6,7,7,10};
	  // int[] num = {1, 5};
	   int [] ans = s.searchRange(num, 10);
	   for(int i = 0; i<2; i++){
		   System.out.print(ans[i] + " ");
	   }
   }
}