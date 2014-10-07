
public class Solution {
	 public double findMedianSortedArrays(int A[], int B[]) {
	     int n = A.length;
	     int m = B.length;
		 if ((n + m) % 2 == 0){
			 return (Find_k_element(A, 0, B, 0, (n + m) / 2)
					 + Find_k_element(A, 0, B, 0, (n + m) / 2 + 1)) / 2.0;
		 }
		 else{
			 return Find_k_element(A, 0, B, 0, (n + m) / 2 + 1);
		 }
	 }
	 private int Min(int a, int b){
		 if (a < b){
			 return a;
		 }
		 else
			 return b;
	 }
	 private int Find_k_element(int[] A, int A_start, int[] B, int B_start, int k){
		
		 if (A_start >= A.length){
			 return B[B_start + k - 1];
		 }
		 if (B_start >= B.length){
			 return A[A_start + k - 1];
		 }
		 if (k == 1){
			 return Min(A[A_start], B[B_start]);
		 }
		 int A_key = A_start + k / 2  < A.length 
				     ? A[A_start + k / 2] : Integer.MAX_VALUE;
		 int B_key = B_start + k / 2  < B.length 
					 ? B[B_start + k / 2] : Integer.MAX_VALUE;
		 if ( A_key < B_key){
			 return Find_k_element(A, A_start + k / 2, B, B_start, k - k / 2);
		 }
		 else 
			 return Find_k_element(A, A_start, B, B_start + k / 2, k - k / 2);
	 }
	 
	 public static void main(String[] Args){
		 Solution s = new Solution();
		 int[] A = {1,2,3};
		 int[] B = {1,2,2};
		 System.out.print(s.findMedianSortedArrays(A, B));
	 }
}
