package wildcardmatching;

public class Solution {
	/*public int match(String des, String sr, int des_start, int sr_start){ //此做法会忽略若*在后面可以匹配另一个字符串对应位置前面的字符串
	   
	if (des_start == des.length() && sr_start == sr.length() ){
		return 1;
	}
	if (des_start == des.length()){  
		return 1;
	}
	if (sr_start == sr.length()){
		return -1;
	}
	
	if (compared[des_start][sr_start] != 0){
		return compared[des_start][sr_start];
	}
	if (sr.charAt(sr_start) == '*'){ // 字符为*既可以空跳过，也可以匹配保留，或者匹配跳过
		compared[des_start][sr_start] = match(des, sr, des_start + 1, sr_start + 1);
		if (compared[des_start][sr_start] != 1 ){
		compared[des_start][sr_start] = match(des, sr, des_start + 1, sr_start);
		}
		if (compared[des_start][sr_start] != 1 ){
		compared[des_start][sr_start] = match(des, sr, des_start, sr_start + 1);
		}
	}
	else if(sr.charAt(sr_start) == '.'){
		compared[des_start][sr_start] = match(des, sr, des_start + 1, sr_start + 1);
	}
	else if (des.charAt(des_start) == sr.charAt(sr_start) ){
		compared[des_start][sr_start] = match(des, sr, des_start + 1, sr_start + 1);
	}
	else{
		compared[des_start][sr_start] = match(des, sr, des_start, sr_start + 1);
	}
	return compared[des_start][sr_start];
}*/
/*public int match(String des, String sr, int n, int m){
	if (n == 0 && m == 0 ){
		return 1;
	}
	if (n <= 0 || m <= 0){  
		return -1;
	}
	
	if (compared[n][m] != 0){
		return compared[n][m];
	}
	//System.out.println(n + " " + m);
	if (sr.charAt(m - 1) == '*'){ // 字符为*既可以空跳过，也可以匹配保留，或者匹配跳过
		compared[n][m] = match(des, sr, n, m - 2);
		if (compared[n][m] == 1)
			return 1;
		int j;
		for ( j = 1; j < n; j++){
			
			if (n - j - 1 >= 0 && m - 2 >= 0 && des.charAt(n - j - 1) == sr.charAt(m - 2)){
				System.out.println((n - j) + " " + (m - 2));
				int temp = match(des, sr, n - j, m - 2);
				if (temp == 1){
					compared[n][m] = 1;
					break;
				}			
			}
		}
		if (j == n + 1)
		compared[n][m] = -1;
	}
	else if(sr.charAt(m - 1) == '.' || des.charAt(n - 1) == sr.charAt(m - 1)){
		compared[n][m] = match(des, sr, n - 1, m - 1);
	}
	else{
		compared[n][m] = -1;
	}
	return compared[n][m];
}
*/
	private int[][] compared;
	/*public boolean isMatch(String s, String p) {
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
    }*/
	/*public int match(String des, String sr, int n, int m){ //A 串代表
	//	System.out.println(n + " " + m);
		if (n > des.length() && m > sr.length()){
			return 1;
		}
		if (n > des.length() ) {
			if (sr.charAt(m - 1) == '*')    //当
				return match(des, sr, n , m + 1);
			return -1;
		}
		if (m > sr.length()){
			return -1;
		}
		if (compared[n][m] != 0){
			return compared[n][m];
		}	
		if (sr.charAt(m - 1) == '*'){ // 当前字符后面为＊
				compared[n][m] = match(des, sr, n + 1 , m);
				if (compared[n][m] != 1){ 
					compared[n][m] = match(des, sr, n , m + 1);
				}
		}
		else {
			if ( sr.charAt(m - 1) == '?' || (sr.charAt(m - 1) == des.charAt(n - 1))){
				compared[n][m] = match(des, sr, n + 1 , m + 1);
			}
			else{
				compared[n][m] = -1;
			}
		}
		return compared[n][m];
	}
	*/
/*	public int match(String des, String sr, int n, int m){ //A 串代表
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
	}*/
	public boolean isMatch(String s, String p) {
        compared = new int[s.length() + 1][p.length() + 1]; 
        int count = 0;
        for (int i = 0; i < p.length(); i++){
       	 if (p.charAt(i) != '*' ){
       		 count++;
       	 }
        }
        if (count > s.length()) return false;
        return match(s, p, 1, 1);
   
   }
	
	public boolean match(String des, String sr, int n, int m){
		int N = des.length(), M = sr.length();
		boolean [][] d = new boolean [N + 1][M + 1];
        d[0][0] = true;
		for (int i = 1; i <= M; i++){
			if (sr.charAt(i - 1) == '*')
				d[0][i] = true;
			else
				break;
		}
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= M; j++){
				if (sr.charAt(j - 1) != '*'){
			        if (sr.charAt(j - 1) == '?' || sr.charAt(j - 1) == des.charAt(i - 1)){
			        	d[i][j] = d[i - 1][j - 1];
			        }
			        else{
			        	d[i][j] = false;
			        }
				}
				else{
						d[i][j] = d[i - 1][j] || d[i][j - 1];
				}
			}

		}
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= M; j++){
				System.out.print(d[i][j] + " ");
			}
			System.out.print("\n");
		}
		return d[N][M];
	}
	public static void main(String[] Args){
		String a = "";
		String b = "*";
		Solution s = new Solution();
		System.out.print(s.isMatch(a, b));
	}
}
