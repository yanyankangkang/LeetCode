import java.util.*;
public class Solution {
	public String getPermutation(int n, int k) {
        int[] num = new int[n];
        String s = "";
        int res = 1;
        for(int i = 0; i < n; i++){
        	num[i] = i + 1;
        	res *= (i + 1);
        }
        nextPermutation(num, k - 1, res / n, n - 1);
        for(int i=0;i<n;i++){
        	s +=  num[i];
        }
        //System.out.print("\n");
        return s;
    }
	
	private void nextPermutation(int[] num, int k, int res, int n){
		int temp;
		int N = num.length;
		int pos = N - 1 - n;
		if (k == 0){
		
			return;
		}
		temp = k / res;
		System.out.print("res=" + res + "  ");
		System.out.print("k=" + k + "  ");
		System.out.print("temp=" + temp + "  ");
		System.out.println("n = "+ n);
		if (temp != 0){
		   exchange(num, temp + pos, pos);
		   Arrays.sort(num, pos + 1, N);
		}
		nextPermutation(num, k % res, res / n, n - 1);
	}
	
	private void exchange(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	public static void main(String [] Agrs){
		Solution s = new Solution();
		int [] num = {1,2,3,4,5};
		int n = 5;
		String ss = s.getPermutation(4, 7); 
        System.out.println(ss);
	}
}
