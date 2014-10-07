package Interleaving_string;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
	  int n = s1.length(), m = s2.length();
	  boolean[][] d = new boolean [n + 1][m + 1];
	  if ( m + n != s3.length())
		  return false;
	  d[0][0] = true;
	  for (int i = 1; i <= n; i++){
		  if (s1.charAt(i - 1) == s3.charAt(i - 1)){
			  d[i][0] = true;
		  }
		  else 
			  break;
	  }
	  for (int i = 1; i <= m; i++){
		  if (s2.charAt(i - 1) == s3.charAt(i - 1)){
			  d[0][i] = true;
		  }
		  else 
			  break;
	  }
      for(int i = 1; i <= n; i++){
    	  for(int j = 1; j <= m; j++){
    		  if (s1.charAt(i - 1) == s3.charAt(i + j - 1)){   
    			  System.out.println(i + " " + j);
    			  d[i][j] = d[i - 1][j];
    		  }
    		  if (!d[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
    			//  System.out.println(s2.charAt(j - 1) + " " + s3.charAt(i + j - 1));
    			  d[i][j] = d[i][j - 1];
    		  }
    	  }
      }
      for (boolean[] res : d){
    	  for (boolean l : res){
    		  System.out.print(l + " ");
    	  }
    	  System.out.print("\n");
      }
      return d[n][m];
      
    }
	
public static void main(String [] Args){
     	Solution s = new Solution();
     	String s1 ="aabc", s2 = "abad", s3 = "aabadabc";
     	System.out.print(s.isInterleave(s1, s2, s3));
 }
}
