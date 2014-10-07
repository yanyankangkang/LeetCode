package Combination_Sum;
import java.util.*;
public class Solution {
	 public ArrayList<ArrayList<Integer>> res;
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		 ArrayList<Integer> one = new ArrayList<Integer>(); 
		 res = new  ArrayList<ArrayList<Integer>>();
	     dfs(candidates, target, 0, one);
		 return res;
	    }
	 
	 public void dfs(int[] candidates, int target, int sum, ArrayList<Integer> one){
		 if (sum == target){
			 res.add(new ArrayList<Integer>(one));
			 return; 
		 }
		 if (sum > target){
			 return;
		 }
		 for (int i = 0; i < candidates.length; i++){
			 if (one.size() == 0 || one.get(one.size() - 1) <= candidates[i]){
				 sum += candidates[i];
				 one.add(candidates[i]);
				 dfs(candidates, target, sum, one);
				 sum -= candidates[i];
				 one.remove(one.size() - 1);
			 }
		 }
	 }
	 public static void main(String[] Args){
		 Solution s = new Solution();
		 ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
		 int []candidates = {2, 3, 4, 7};
		 int target = 7;
		 res = s.combinationSum(candidates, target);
		 for (ArrayList<Integer> i : res){
			 for (Integer j : i ){
				 System.out.print(j + " ");
			 }
			 System.out.print("\n");
		 }
	 }
}
