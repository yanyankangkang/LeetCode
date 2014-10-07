package Decode_Ways;

public class Solution {
	 
	 
	 public int numDecodings(String s) {
		 if (s.length() == 0)
			 return 0;
		 
	     int[] d = new int [s.length() + 1];
	     if (s.charAt(0) - '0' > 0) 
	    	 d[1] = 1;
	     else 
	    	 d[1] = 0;
	     d[0] = 1;
	     for (int i = 2; i <= s.length(); i++){
	    	 int num1 = s.charAt(i-1) - '0';
	    	 int num2 = s.charAt(i-2) - '0';
             if (num1 > 0)
	    	 d[i] = d[i-1];
	    	 int num = num2;
	    	 num = num * 10 + num1;
	    	 if (num2 > 0 && num <= 26 && num > 0){
	    		 d[i] += d[i-2];
	    	 }
	     }
	     return d[s.length()];
		 
	 }
	 public static void main(String[] Agrs){
		 Solution s = new Solution();
		 String s1 = "01";
		 System.out.print(s.numDecodings(s1));
	 }
}
