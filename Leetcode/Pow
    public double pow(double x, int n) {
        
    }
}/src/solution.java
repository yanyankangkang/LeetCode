
public class solution {
	
	public double pow(double x, int n){
		if (n == 0){
			return 1;
		}
		if (Math.abs(n)%2 == 1){
			if (n > 0){
				return x * pow(x, n + (n < 0 ? 1:-1));
			}
			else{
				return pow(x, n + (n < 0 ? 1:-1)) / x;
			}
		}
		else{
			double temp = pow(x, n/2);
			return  temp * temp;
		}
	}
	public static void main(String[] Args){
		solution s = new solution();
		System.out.println(s.pow(34.00515, -3));
	}
}
