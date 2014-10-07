package Palindrome_Partitioning;
// mincut 状态转移方程 F(i) = min(F(j) + 1) (s(j+1, i)是回文串), 同时回文串也有状态转移方程F[i,j] = F[i+1, j-1] (s[i] == s[j])

public class Solution {
	private boolean[][] Pr;
	private boolean is_Palindrome(String s, int i, int j){
		/*int N = s.length();
	    for(int i = 0; i < N / 2; i++){
	    	if (s.charAt(i) != s.charAt(N - 1 - i)){
	    		return false;
	    	}
	    }
	    return true;
	    */
		if (s.charAt(i - 1) == s.charAt(j - 1)){
			if ( (i + 1) > (j - 1)){
				Pr[i][j] = true;
			}
			else{
				Pr[i][j] = Pr[i + 1][j - 1];
			}
		}
		else{
			Pr[i][j] = false;
		}
		return Pr[i][j];
	}
	private int Min_Value(int a, int b){
		return a < b ? a : b;
	}
	public int minCut(String s) {
        int N = s.length();
        int[] mincut = new int[N + 1];
        Pr = new boolean[N + 1][N + 1]; 
        int Min;
        for(int i = 0; i <= N ; i++){
        	Pr[i][i] = true;
        }
		for(int i = 1; i <= N; i++){
			if (1 == i){
			Min = mincut[i - 1];
			}
			else{
				Min = mincut[i - 1]	+ 1 ;
			}
			for(int j = 1; j < i ; j++){
			if (is_Palindrome(s, j, i)){
				if (j == 1){
					Min = 0;
				}
				else if (Min > mincut[j - 1] + 1){
					Min = mincut[j - 1] + 1;
					}
				}
			}
			mincut[i] = Min;
		}
		/*for (int i = 0; i < N; i++){
		 System.out.print(mincut[i] + " ");
		}
		 System.out.print("\n");*/
		for (int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(Pr[i][j] + " ");
			}
			System.out.print("\n");
		}
		return mincut[N];
    }
	
	public static void main(String[] Args){
		Solution s = new Solution();
		String s1 = "";
		System.out.print(s.minCut(s1));
	}
}
