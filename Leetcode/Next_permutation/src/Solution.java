import java.util.*;
public class Solution {
	public void nextPermutation(int[] num) {
        int N = num.length;
        int pos = -1;
        int local_min = -1; 
		for(int i = N - 1; i > 0; i--){
			if (num[i] > num[i-1]){
			    pos = i ;
				break;
			}
		}
		if ( pos == 0){
			Arrays.sort(num);
		}
		else{
			for(int i = N - 1; i >= pos; i-- ){
				if (num[i] > num[pos - 1]){
					local_min = i;
					break;
				}
			}
			exchange(num, local_min, pos - 1);
			Arrays.sort(num, pos, N);
		}
    }
	private void exchange(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	public static void main(String [] Args){
		int [] num = {2,3,1,1};
		Solution s = new Solution();
		s.nextPermutation(num);
		for(int i = 0; i < num.length; i++ ){
			System.out.print(num[i]);
		}
	}
}
