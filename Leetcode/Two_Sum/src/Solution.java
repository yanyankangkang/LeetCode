import java.util.*;
public class Solution {
	   public int[] twoSum(int[] numbers, int target) { 
	       int i = 0, j = numbers.length - 1;
	       int[] index = new int[2];
	       int[] raw_number = new int[numbers.length];
	       for(int k = 0; k < numbers.length; k++){
	           raw_number[k] = numbers[k];
	       }
	       Arrays.sort(numbers);
	       while(i < j){
	    	   if (numbers[i] + numbers[j] > target){
	    		   j--;
	    	   }
	    	   else if(numbers[i] + numbers[j] < target){
	    		   i++;
	    	   }
	    	   else{
	    		   index[0] = i;
	    		   index[1] = j;
	    		   break;
	    	   }
	       }
	       System.out.println(index[0]);
		   System.out.println(index[1]);
	       for(i = 0; i < numbers.length; i++){
	           if (numbers[index[0]] == raw_number[i] ){
	               index[0] = i;
	               break;
	           }
	          
	       } 	
	       
	       for(i = 0; i < numbers.length; i++){
	           if (numbers[index[1]] == raw_number[i] && index[0] != index[1]){
	               index[1] = i;
	               break;
	           }
	          
	       }
	       index[0]++;
	       index[1]++;
			return index; 
	    }
	
	public static void main(String[] Args){
		int[] num = {3, 2, 4};
		int[] index = new int[2];
		Solution s = new Solution();
		index = s.twoSum(num, 6);
		System.out.println(index[0]);
		System.out.println(index[1]);
	}
}
