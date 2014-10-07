package hw1;

public class Q7 {
	static public void find(){
	  //int d[] = new int[10];
	  int sum = 0;
	  int right = 0,wrong = 0;
	  for (int i = 2; i <= 10; i++){
		    if (i%2 == 1){
		    	sum -= i * i;
		    	right += Math.abs(sum);
		    }
		    else{
		    	sum += i * i;
		    	wrong += sum;
		    }
		    System.out.println("case:" + i);
		    System.out.println("wrong: "  + wrong +"  right: " + right);
		    if (sum < 0){
		    System.out.println("wrong: "  + Math.abs(sum) + " " + i * i);
		    }
		    else {
		    System.out.println("right: "  + Math.abs(sum) + " " + i * i);
		    }
	  }
	}
	static public double figure(double p){
		return - p * Math.log(p) / Math.log(2) - (1 - p) * Math.log(1 - p) / Math.log(2);
	}
	static public double figure1(double p){
		return - p * Math.log(p) / Math.log(2);
	}
	public static void main(String[] Args){
		System.out.println( 7 * figure(1.0/2)/8 );
		
		//System.out.println(figure(1.0/5)/2 + figure1(1.0/10)/2 );
	}
}
