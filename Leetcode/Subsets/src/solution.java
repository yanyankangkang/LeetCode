import java.util.*;
public class solution {
	 public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	        int N = S.length;
	       // ArrayList<Integer> vis = new ArrayList();
	        Arrays.sort(S);
		    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		    ArrayList<ArrayList<Integer>> last =  new ArrayList<ArrayList<Integer>>();
		    result.add(new ArrayList<Integer>());
	        for(int i = 0; i < N; i++ ){
	        	ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	        
	        	//System.out.println("ArrayList_size =" + result.size() );
	            if (i==0 || S[i] != S[i-1]){

	        	for (ArrayList<Integer> l : result){
	        		/*System.out.print("raw l ");
	        		for(Integer j : l){
	    				System.out.print(j);
	    			}
	    			System.out.print("\n");
	    			*/
	    			ArrayList<Integer> temp = new ArrayList<Integer>(l);
	    			temp.add(S[i]);
	        		current.add(temp);
	        		/*System.out.print("updated l ");
	        		for(Integer j : l){
	    				System.out.print(j);
	    			}
	    			System.out.print("\n");
	    			*/
	        	}
    			//System.out.print("\n");
	        	//ArrayList<Integer> single = new ArrayList<Integer>(S[i]);
	        	//current.add(single);
	        	
	        
	            }
	            else{
	            	for (ArrayList<Integer> l : last){
		        		/*System.out.print("raw l ");
		        		for(Integer j : l){
		    				System.out.print(j);
		    			}
		    			System.out.print("\n");
		    			*/
		    			ArrayList<Integer> temp = new ArrayList<Integer>(l);
		    			temp.add(S[i]);
		        		current.add(temp);
		        		/*System.out.print("updated l ");
		        		for(Integer j : l){
		    				System.out.print(j);
		    			}
		    			System.out.print("\n");
		    			*/
		        	}
	            	
	            }	
	            result.addAll(current);
	        	last = new ArrayList<ArrayList<Integer>> (current);
	        	/*System.out.print("**");
	        	for (ArrayList<Integer> l : current){
	    			for(Integer j : l){
	    				System.out.print(j);
	    			}
	    			System.out.print("\n");
	    		}
	        	System.out.print("**");
	        	*/
	        }
	        return result;
	    }
	public static void main(String[] Args){
		int[] num = {1,2,2};
		solution s = new solution();
		ArrayList<ArrayList<Integer>> ans = s.subsets(num); 
		for (List<Integer> l : ans){
			for(Integer i : l){
				System.out.print(i);
			}
			System.out.print("\n");
		}
	}
}
