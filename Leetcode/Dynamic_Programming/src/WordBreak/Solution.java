package WordBreak;
import java.util.*;
public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
        int N = s.length();
		boolean [] wb = new boolean [N + 1];
		wb[0] = true;
		for (int i = 1; i <= N; i++){
			
			for(int j = 1; j <= i; j++){
				if (!wb[i]){
				if (dict.contains(s.substring(j - 1, i))){
					wb[i] = wb[j - 1]; 
				}
				else{
					wb[i] = false;
				}
				}
			}
		} 
		return wb[N];
    }
	
	public static void main(String[] Args){
		Set<String> dict = new HashSet<String>();
		String[] s = {"lee1t", "code"};
		for (int i = 0; i < s.length; i++){
			dict.add(s[i]);
		}
		String des = "leetcode";
		Solution solution = new Solution();
		System.out.print(solution.wordBreak(des, dict));
	}
}
