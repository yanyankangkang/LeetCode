package longest_consective_common_substring;

public class solution {
	//d[i][j]表示当s1,和s2分别以第i,j位结束时最长公共连续字串的长度
	//初始化：两个字符串都为0时d[0][0] = 0
	//状态转移方程 d[i][j] = Max(d[i-1][j-1]+1,d[i][j])除了对应位置比较还要看如果我不比较i位或者j位的情况
	//返回d[s1.len][s2.len]
	public int find(String s1, String s2){
		int d[][] = new int [s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++)
			for(int j = 1; j <= s2.length(); j++){
					if (s1.charAt(i - 1) == s2.charAt(j - 1)){
						d[i][j] = d[i - 1][j - 1] + 1;
					}
					else{
						d[i][j] = 0;
					}
			}
		int Max = 0;
		for(int i = 0; i <= s1.length() ;i++){
			for(int j = 0;j <= s2.length() ;j ++){
				Max = Math.max(d[i][j], Max);
			}
		}
		return Max;
	}
	public static void main(String[] Args){
		String s1 = "bbaac", s2 = "bbbaa";
		solution s = new solution();
		System.out.println(s.find(s1, s2));
	}
}
