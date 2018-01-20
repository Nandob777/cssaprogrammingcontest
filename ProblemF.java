import java.util.*;
public class ProblemF{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int[] num = new int[sc.nextInt()];
			for(int i = 0; i < num.length; i++){
				num[i] = sc.nextInt();
			}
			if(num.length != 0){ System.out.println(tallestStack(num)); }
		}
	}

	private static int tallestStack(int[] num){
		int[] num2 = new int[num.length];
		for(int i = 0; i < num2.length; i++){
			num2[i] = num[i];
		}
		return 0;
	}
}
