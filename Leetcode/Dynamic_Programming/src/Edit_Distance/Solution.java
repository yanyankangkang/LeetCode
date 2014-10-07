package Edit_Distance;

public class Solution {
	private int Min(int a, int b){
		return a < b ? a : b;
	}
	public int minDistance(String word1, String word2) {
        int m = word2.length(), n = word1.length();
        int[][] d = new int[n + 1][m + 1]; 
        for(int i = 1; i <= n; i++ ){
        	d[i][0] = i;
        }
        for(int i = 1; i <= m; i++ ){
        	d[0][i] = i;
        }
        for(int i = 1; i <= n; i++){
        	for(int j = 1; j <= m; j++){
        	  d[i][j] = Min(Min(d[i][j - 1], d[i - 1][j]) + 1,  d[i - 1][j - 1] + (word2.charAt(j - 1) == word1.charAt(i - 1) ? 0 : 1));
        	}// d[i-1][j] 第一个字符串删除 d[i][j-1] 第二个字符串插入 d[i-1][j-1]改变第i个或第j个数ß
        }
        
     /*   for(int i = 0; i <= n; i++ ){
        	for(int j = 0; j<= m; j++){
        		System.out.print(d[i][j] + " ");
        	}
        	System.out.print("\n");
        }*/
        return d[n][m];
    }
	public static void main(String [] Args){
		Solution s = new Solution();
		String s1 = "plasma", s2 = "altruism";
		System.out.println(s.minDistance(s1, s2));
	}
}
