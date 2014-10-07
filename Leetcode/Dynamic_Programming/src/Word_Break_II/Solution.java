package Word_Break_II;
import java.util.*;
public class Solution {
	
   /* class Word{
    	ArrayList<ArrayList<Integer>> l;
    	boolean valid;
    	public Word(){
    		l = new ArrayList<ArrayList<Integer>>();
    		valid = false;
    	}
    }
    public Word[] d ;  
    */
	/*public List<String> wordBreak(String s, Set<String> dict) {
	     int N = s.length();
		 d = new Word[N + 1];
		 int M = dict.size();
		 String[] array_dict = new String[M] ;
		 dict.toArray(array_dict);
	
		 for ( int i = 0; i <= N; i++){
			 d[i] = new Word();
		 }
		 
		 d[0].valid = true; 
	     for (int i = 1; i <= N; i++){
	    	 for (int j = 0; j < M; j++){
	    		 int l  = array_dict[j].length();
	    		 int start = i - l + 1;
	    		 if (start > 0)
	    		// System.out.println(s.substring(start - 1, i) + "," + word + "," +s.substring(start - 1, i).equals(word));
	    		 if (start > 0 && s.substring(start - 1, i).equals(array_dict[j])){
	    			 
	    		     if (d[start - 1].valid){
	    		    	 if (d[start - 1].l.size() == 0){
	    		    		 d[i].l.add(new ArrayList<Integer>(j));
	    		    	 }
	    		    	 else{
	    		    		 for (ArrayList<Integer> num : d[start - 1].l){
	    		    			 ArrayList<Integer> temp = new ArrayList<Integer>(num);
	    		    			 temp.add(j);
	    		    			 d[i].l.add(temp);
	    		    		 }
	    		    	 }
	    		    	 d[i].valid = true;
	    		     }
	   
	    		 }
	    	 }
	     }
	     List<String> l = new ArrayList<String>();
	     for (ArrayList<Integer> list : d[N].l){
	    	 String str ="";
	    	 for (Integer index : list){
	    		 if (str == ""){
	    			 str = array_dict[index];
	    		 }
	    		 else{
	    		 str +=  " " + array_dict[index]; 
	    		 }
	    	 }
	    	 l.add(str);
	     }
	   return l;  
	}*/
	boolean[] cut;
	public List<String> wordBreak(String s, Set<String> dict) {
		  int N = s.length();		
		cut = new boolean[N + 1];
		 cut[0]= true; 
		 for (int i = 1; i <= N; i++){
	    	 for (String word : dict){
	    		 int l  = word.length();
	    		 int start = i - l + 1;
	    		 if (start > 0)
	    		// System.out.println(s.substring(start - 1, i) + "," + word + "," +s.substring(start - 1, i).equals(word));
	    		 if (!cut[i] && start > 0 && s.substring(start - 1, i).equals(word)){
	    			 cut[i] = cut[start - 1];
	    		 }
	    	 }
	     }
	/*	 for (int i = 1; i <= N; i++){
			 System.out.print(cut[i] + " ");
		 }*/
		list = new ArrayList<String>();
		 v = new ArrayList<String>();
		 Print(s, dict, N);
		return list;
	}
	 ArrayList<String> v;
	 ArrayList<String> list;
	public void Print(String s, Set<String> dict, int pos ) {
		if (pos == 0){
		   String[] str = new String [v.size()];
		   int c = 0;
		  
		   for ( String word : v){
			   str[c++] = word;
		   }
		   String res = str[c - 1];
		   for (int i= c - 2; i>= 0; i--){
			   res += " " + str[i];
		   }
		   //System.out.println(res);
		   list.add(res);
		   return ;
		 //  System.out.println(res);
		}
		for (String word : dict){
			int l = word.length();
			int start = pos - l;
		//	System.out.println(start + " " + word);
			if (start >= 0 && cut[start] && s.substring(start, pos).equals(word)){
				
				v.add(word);
				Print(s, dict, start);
				v.remove(v.size() - 1);
			}
		}
	}
	public static void main(String[] Args){
		Solution s = new Solution();
		String s1 = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		String s2 = "aaaaaaaa";
		Set<String> dict2 = new HashSet<String>();
		dict2.add("aa");
		dict2.add("aaa");
		dict2.add("aaaa");
		
	//	System.out.println(dict.size());
		List<String> list = s.wordBreak(s2, dict2);
	//	System.out.println(list.size());
		for (String l : list){
			System.out.println(l);
		}
		
	}
}
