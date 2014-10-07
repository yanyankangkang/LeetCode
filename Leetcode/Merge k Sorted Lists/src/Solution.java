
public class Solution {
	public boolean canJump(int[] A) {
        int[] step = new int[A.length];
        step[0] = 0;
		for(int i = 0; i < A.length; i++){
			for(int j = 1; j < A[i]; j++){
				int new_pos;
				if( i + j >= A.length ){
					new_pos = A.length - 1;
				}
				else{
					new_pos = i + j;
				}
				if (i == 0 || step[i] != 0 && step[new_pos] > step[i] + 1){
					step[new_pos] = step[i] + 1;
				}
			}
		}
		for (int i = 0 ;i < A.length; i++){
    		System.out.println(step[i]);
    	}
		return step[A.length - 1] != 0;
    }
   
	private int Min(int a, int b){
		return (a < b ? a : b);
	}

	public int Jump(int[] A){
		int pos = 0, step = 0;
		int jump_pos, jump_temp;
		int N = A.length;
		int Max, SecondMax, index = 1;
		
		Max = -1;
		while (pos < N - 1){
			SecondMax = -1;
			jump_pos = pos;
			jump_temp = pos;
			if ( pos + A[pos] >= A.length - 1){
				
				return ++step;
			}
			for (int i = index; i <= pos + A[pos]; i++){
					if ( SecondMax < A[i] + i){
						SecondMax = A[i] + i;
						jump_temp = i;
					}
					if  ( Max <= SecondMax){
						Max = SecondMax;
						SecondMax = -1;
						jump_pos = jump_temp;
					}
			}
			
			if (Max >= 0){
			index = jump_pos + 1;
			   pos = jump_pos;
			   step++;
			}
			else{
				return -1;
			}
			Max = SecondMax;
            jump_pos = jump_temp;
           // System.out.println(pos + " " );
			
		}
		return step;
	}
    public static void main(String[] Args){
    	Solution s = new Solution();
    	int [] num = {2, 1};
    	System.out.print( s.Jump(num) );
    	
    }
    
}
