import java.util.*;

public class ProblemD{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = 1;
		while(sc.hasNextInt()){
			int num = sc.nextInt();
			if(num == 0){ break; }
			int[] jumps = new int[num];
			for(int i = 0; i < num; i++){
				jumps[i] = sc.nextInt();
			}
			System.out.println("Circuit #" + count++ + ": " + janice(jumps));
		}
	}

	public static long janice(int[] jumps){
		long[] spaces = new long[jumps.length + 1];
		spaces[0] = 0;
		for(int i = 0; i < jumps.length; i++){
			spaces[i+1] = spaces[i] + (long)jumps[i];
		}
		Arrays.sort(spaces);
				
		long common = spaces[0];
		int commonCount = 0;
		long contender = spaces[0];
		int contenderCount = 0;
		for(int i = 0; i < spaces.length; i++){
			if(spaces[i] != contender){
				if(contenderCount > commonCount || (contenderCount == commonCount && contender < common)){
					common = contender;
					commonCount = contenderCount;
				}
				contender = spaces[i];
				contenderCount = 0;
			}
			contenderCount++;
		}
		if(contenderCount > commonCount || (contenderCount == commonCount && contender < common)){
			common = contender;
			commonCount = contenderCount;
		}
		return common;
	}

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
