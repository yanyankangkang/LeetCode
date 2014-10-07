package Distinct_Subsequences;

public class Solution {
	public int numDistinct(String S, String T) {
        int N = S.length(), M = T.length();
		int[][] d = new int[M + 1][N + 1];

		for (int i = 0; i <= N; i++){
			d[0][i] = 1;
		}
		for (int i = 1; i <= M; i++){
			for(int j = i; j <= N; j++){
				if (j > i)
				d[i][j] = d[i][j - 1];
				if (T.charAt(i - 1) == S.charAt(j - 1) ){
					d[i][j] += d[i - 1][j - 1];
				}
			}
		}
		
		/*for (int i = 0; i <= M; i++){
			for(int j = 0; j <= N; j++){
				System.out.print(d[i][j] + " ");
			}
			System.out.print("\n");
		}*/
		return d[M][N];
    }
	
	public static void main(String[] Args){
		/*Solution s = new Solution();
		String s1 = "rabbbit", s2 = "rabbit";
		System.out.print(s.numDistinct(s1, s2));*/
		System.out.print(0x80000000 >>> 31);
	}
}
