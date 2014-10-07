import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Solution {
	 public List<List<Integer>> permute(int[] num) {
	        N = num.length;
	        flag = new boolean[N];
	        One_permutation = new ArrayList<Integer>();
	        All_permutations = new ArrayList<List<Integer> >();
	        Permutation(0, num);
	        return All_permutations;
	    }
	    private List<Integer> One_permutation;
	    private List<List<Integer> > All_permutations;
	    private int N;
	    private boolean[] flag;
	    private void Permutation(int pos, int[] num){
	        if (pos == N){
	        //	System.out.println(!All_permutations.contains(One_permutation));
	        //   if ( !All_permutations.contains(One_permutation) ){
	        	//System.out.println("*" + One_permutation.size());
	               All_permutations.add(One_permutation);
	               for (int j = 0; j < One_permutation.size() ; j++){
	         		  System.out.print(One_permutation.get(j) + " ");
	         	  }
	               
	           //}   System.out.println("\n");
	        }
	        for (int i = 0; i < N; i++){
	             if (!flag[i]){
	             flag[i] = true;
	             One_permutation.add(num[i]);
	             Permutation(pos + 1, num);
	             One_permutation.remove(One_permutation.size() - 1);
	             flag[i] = false;
	             }
	        }
	    }
    public static void main(String[] args){
      Solution p = new Solution();
      int[] num = {1,2,3};
      List<List<Integer> > All_permutations = p.permute(num);
      Iterator it = All_permutations.iterator();
     
      for (int i = 0; i < All_permutations.size(); i++){
    	  List<Integer> temp_permutation = All_permutations.get(i);
    	  for (int j = 0; j < temp_permutation.size() ; j++){
    		  System.out.print(temp_permutation.get(j) + " ");
    	  }
    	  System.out.println("\n");
      }
    }
    
}