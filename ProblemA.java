import java.util.*;
public class ProblemA{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int caseN = 1;
		while(true){
			int numNodes = sc.nextInt();
			int numOps = sc.nextInt();
			if(numNodes == 0 && numOps == 0){ break; }
			System.out.println("Case " + caseN++ + ":");
			int nodes[] = new int[numNodes];
			for(int i = 0; i < numNodes; i++){ nodes[i] = -1; }
			for(int i = 0; i < numOps; i++){
				sc.nextLine();
				char command = sc.next().charAt(0);
				if(command == '+'){
					join(sc.nextInt(),sc.nextInt(),nodes);
				}else if(command == '?'){
					System.out.println(checkTree(sc.nextInt(),sc.nextInt(),nodes));
				}else{ 
					System.out.println("Invalid command: '" + command + "'");
				}
			}
		}
	}

	public static void join(int a, int b, int[] uptree){
		if(a == b){
			//do nothing
		} else if(uptree[a] < 0 && uptree[b] < 0){
			uptree[a] += uptree[b];
			uptree[b] = a;
		} else if(uptree[a] > -1 && uptree[b] > -1){
			join(uptree[a],uptree[b],uptree);
		} else if(uptree[a] > -1){
			join(uptree[a],b,uptree);
		} else if(uptree[b] > -1){
			join(uptree[b],a,uptree);
		}
	}

	public static boolean checkTree(int a, int b, int[] uptree){
		return root(a,uptree) == root(b,uptree);
	}

	public static int root(int a, int[] uptree){
		if(uptree[a] > -1){ return root(uptree[a], uptree);}
		else{ return a; }
	}
}
