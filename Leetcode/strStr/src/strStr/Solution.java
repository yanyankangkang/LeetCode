package strStr;
public class Solution {
	   public String strStr(String haystack, String needle) {
	        int i, j;
	        if ( haystack == null || needle == null){
	            return null;
	        }
	        for(i = 0; i < haystack.length() - needle.length() + 1 ; i++){
	            for(j = 0; j < needle.length(); j++){
	                if( needle.charAt(j) != haystack.charAt(i + j)){
	                     break;
	                }
	            }
	            if(j == needle.length())
	               return haystack.substring(i);
	        }
	        return null;
	    }
	   public static void main(String[] Args){
		   Solution s = new Solution();
		   System.out.println(s.strStr("", ""));
	   }
	 
}
