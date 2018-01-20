import java.util.*;

public class ProblemE{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println(canWin(sc.nextInt(),sc.nextInt()));
		}
	}
	
	public static String canWin(int n, int k){
		if(win(n,k)){
			return "Winner";
		}else{
			return "Loser";
		}
	}

	public static boolean win(int n, int k){
		if(n == 0){
			return false;
		}else if(n <= k){
			return !win(0, k);
		}else if(isEven(n/k) && mod(n,k) != 0){
			return !win(n-k+1,k);
		} else { return !win((n/k)*k,k);}
	}

	private static boolean isEven(int n){
		return (n/2)*2 == n;
	}

	private static int mod(int n, int base){
		return n - (n/base);
	}
}
