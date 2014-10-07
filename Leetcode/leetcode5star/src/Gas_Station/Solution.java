package Gas_Station;

public class Solution {
public int canCompleteCircuit(int[] gas, int[] cost) {
        int []sum = new int[gas.length];
        int []diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++){
        	diff[i] = gas[i] - cost[i];
        }
        
       
    }
	public static void main(String[] Args){
		Solution s = new Solution();
		int [] gas ={1,2,3,4,5};
		int [] cost = {3,4,5,1,2};
		System.out.print(s.canCompleteCircuit(gas, cost));
	}
}
