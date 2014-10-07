package Jump_Game;

public class Solution {
	public int jump(int[] A){
		int []d = new int [A.length];
		int n = A.length;
		for (int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(j + A[j] >= i){
					d[i] = (d[i] == 0 ? d[j] + 1 : Math.min(d[i], d[j] + 1));
					break;
				}
			}
		}
		return d[n - 1];
	}
	public static void main(String[] Args){
		int [] num = {2,3,1,1,4};
		Solution s = new Solution();
		System.out.println(s.jump(num));
	}
}
