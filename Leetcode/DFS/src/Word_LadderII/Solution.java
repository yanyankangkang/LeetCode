package Word_LadderII;
import java.util.*;
public class Solution {
	public ArrayList<ArrayList<String>> res;
	public ArrayList<ArrayList<String>> level; 
	public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
		res = new ArrayList<ArrayList<String>>();
		level = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(start);
		dfs(start, end, dict, temp);
		return res;
	  }
	public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();  
        ArrayList<String> tempArray;
        q.offer(start);
        dict.add(end);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            step++;
            tempArray = new ArrayList<String>();
            for (int i = 0; i < size; i++){
            	String word = q.poll();
            	for (char ch = 'a'; ch <= 'z'; ch++){
            		for (int j = 0; j < word.length(); j++){
            			String temp = replace(word, j, ch);
            			tempArray.add(temp);
            			if (temp.equals(end)){
            				level.add(tempArray);
            				return 1 + step;
            			}
            			if (dict.contains(temp)){
        					q.offer(temp);
        			    	dict.remove(temp);
        					}
            			}
            		}
            	}
            level.add(tempArray);
        	}
        return 0;
    }
	public void dfs(String start, String end, Set<String> dict, ArrayList<String> temp){
		for (char ch = 'a'; ch <= 'z'; ch++){
			for (int i = 0; i < end.length(); i++){
				String word = replace(start, i, ch);
			/*	if (word == "cog"){
					System.out.print(word);
				}*/
				if (word.equals(end)){
					temp.add(end);
					if (res.size() == 0 || res.get(0).size() == temp.size()){ 
						res.add(new ArrayList<String>(temp));
					}
					else if (res.get(0).size() > temp.size()){
						res = new ArrayList<ArrayList<String>>();
						res.add(new ArrayList<String>(temp));
					}
					temp.remove(end);
					return;
				}
				if (dict.contains(word)){
					dict.remove(word);
					temp.add(word);
					dfs(word, end, dict, temp);
					dict.add(word);
					temp.remove(word);
				}
			}
		}
	}
	public String replace(String s, int i, char c){
		char [] ch = s.toCharArray();
		ch[i] = c;
		return new String(ch); //convert charArray to string not ch.tostring()
	}
	
	public static void main(String[] Args){
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		String [] word = {"hot","dot","dog","lot","log"};
		for (int i = 0; i < word.length; i++){
			dict.add(word[i]);
		}
		Solution s = new Solution();
		ArrayList<ArrayList<String>> res = s.findLadders(start, end, dict);
		for (ArrayList<String> words : res){
			for (String l : words){
				System.out.print(l + " ");
			}
			System.out.print("\n");
		}
	}
}
