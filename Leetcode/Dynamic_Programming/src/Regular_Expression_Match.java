
public class Regular_Expression_Match {
	private int[][] compared;
	public boolean isMatch(String s, String p) {
        compared = new int[s.length() + 1][p.length() + 1]; 
        int count = 0;
        for (int i = 0; i < p.length(); i++){
       	 if (p.charAt(i) != '*' ){
       		 count++;
       	 }
        }
        if (count > s.length()) return false;
        if (match(s, p, 1, 1) == 1)
       	 return true;
        else {
       	 return false;
        }
   }
	public int match(String des, String sr, int n, int m){ //A 串代表
		if (n > des.length() && m > sr.length()){
			return 1;
		}
		if (n > des.length() ) {
			if (m < sr.length() && sr.charAt(m) == '*')    //trick: 当待匹配字符串已经匹配完，但是还有很多＊时，需要跳过星号判断模式串匹配，如果发现有字符后面不是*则匹配失败否则匹配成功
				return match(des, sr, n , m + 2);
			return -1;
		}
		if (m > sr.length()){
			return -1;
		}
		if (compared[n][m] != 0){
			return compared[n][m];
		}	
		if (m < sr.length() && sr.charAt(m) == '*'){ // 当前字符后面为＊时，如果模式串字符和带匹配字符相等或者一个为'.'时，则向后观察如果重复当前字符两次能否匹配
			if ((des.charAt(n - 1) == sr.charAt(m - 1) || sr.charAt(m - 1) == '.')){
				compared[n][m] = match(des, sr, n + 1 , m);	
			}
			if (compared[n][m] != 1){ //如果重复字符失败则尝试跳过模式串的当前字符，从＊后的字符开始匹配 
			//	System.out.println(n + " " + m + " " + compared[n][m]);
				compared[n][m] = match(des, sr, n , m + 2);
			}
		}
		else {// 如果当前字符后面不为＊时，则着眼于当前字符的判断，同样的若模式串中有'.' 或者字符相同时则表示匹配成功，接着可看后面的字符串是否相同
			if ( sr.charAt(m - 1) == '.' || (sr.charAt(m - 1) == des.charAt(n - 1))){
				compared[n][m] = match(des, sr, n + 1 , m + 1);
			}
			else{//否则当前长度字符串对应字符匹配失败
				compared[n][m] = -1;
			}
		}
		return compared[n][m];
	}
}
