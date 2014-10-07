package Word_Ladder;

import java.util.*;

public class Solution {

	public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();  	   
        q.offer(start);
        dict.add(end);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++){
            	String word = q.poll();
            	for (char ch = 'a'; ch <= 'z'; ch++){
            		for (int j = 0; j < word.length(); j++){
            			String temp = replace(word, j, ch);
            			if (temp.equals(end))
            				return 1 + step;
            			if (dict.contains(temp)){
        					q.offer(temp);
        			    	dict.remove(temp);
        					}
            			}
            		}
            	}
        	}
        return 0;
    }
	public String replace(String s, int i, char c){
		char [] ch = s.toCharArray();
		ch[i] = c;
		return new String(ch); //convert charArray to string not ch.tostring()
	}
	/*public boolean misOne(String a, String b){
		int c = 0;
		for (int i = 0; i < a.length(); i++){
			if (a.charAt(i) != b.charAt(i)){
				c++;
			}
			if (c > 1)
				return false;
		}
		if (c == 0)
			return false;
		return true;
	}*/
	
	public static void main(String[] Args){
	    Solution s  = new Solution();
	    String start = "hit";
	    String end = "cog";
	    Set<String> dict = new HashSet<String>();
	    dict.add("hot");
	    dict.add("dot");
	    dict.add("dog");
	    dict.add("lot");
	    dict.add("log");
	    System.out.print(s.ladderLength(start, end, dict));
	}
	
}
