import java.util.*;

public class ProblemH{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while(num-- > 0){
			int[][] pos = new int[4][2];
			for(int i = 0; i < pos.length; i++){
				for(int j = 0; j < pos[i].length; j++){
					pos[i][j] = sc.nextInt();
				}
			}
			System.out.println(process(pos));
		}
	}

	public static String process(int[][] pos){
		boolean square = true;
		boolean rectangle = true;
		int[][] distsq = new int[4][4];
		for(int i = 0; i < pos.length; i++){
			for(int j = 0; j < pos.length; j++){
				int xdist = pos[i][0] - pos[j][0];
				int ydist = pos[i][1] - pos[j][1];
				xdist = xdist*xdist;
				ydist = ydist*ydist;
				distsq[i][j] = xdist + ydist;
			}
			Arrays.sort(distsq[i]);
		}
		
		for(int i = 0; i < distsq.length - 1 && (square || rectangle); i++){
			for(int j = 0; j < distsq[i].length; j++){
				if(distsq[i][1] + distsq[i][2] != distsq[i][3]){
					square = false;
					rectangle = false;
				}
				if(distsq[i][1] != distsq[i][2]){
					square = false;
				}
			}
		}

		if(square){ return "SQUARE"; }
		else if(rectangle){ return "RECTANGLE"; }
		else{ return "NEITHER"; }		
	}
}
