
import java.util.ArrayList;
import java.util.HashMap;

public class MiniMax {
	public static final int SUGGESTIVE_MAX_DEPTH = 10;
	public static int counter;
	//AI (white), depth>0
	public static int[]  getComputerMove(Board b, int depth) {
		ArrayList<ArrayList<Integer>> coloredMoves = b.getAllMoves(true);
		int[] currentMove = new int[4];
		int max = Integer.MIN_VALUE;
		int[] bestMove = new int[4];
		for (int k = 0; k < coloredMoves.size(); k++) {
			ArrayList<Integer> a = coloredMoves.get(k);
			for (int i = 2; i < a.size() - 1; i += 2) {
				currentMove[0] = a.get(0);
				currentMove[1] = a.get(1);
				currentMove[2] = a.get(i);
				currentMove[3] = a.get(i + 1);
				int moveSetValue = min(b.simulateMove(currentMove), depth - 1, max, Integer.MAX_VALUE);
				if (moveSetValue > max) {
					max = moveSetValue;
					bestMove = currentMove.clone();
				}
			}

		}
		return bestMove; 
	}
	//maximizer (white)
	private static int max(Board b, int depth, int alpha, int beta) {
		if (depth == 0 || Math.abs(b.getSum()) > 999990) { counter++; 
			return b.getSum(); 
		}
		ArrayList<ArrayList<Integer>> coloredMoves = b.getAllMoves(true);
		for (int k = 0; k < coloredMoves.size(); k++) {
			ArrayList<Integer> a = coloredMoves.get(k);
			for (int i = 2; i < a.size() - 1; i += 2) {
				int[] moveSet = new int[4];
				moveSet[0] = a.get(0);
				moveSet[1] = a.get(1);
				moveSet[2] = a.get(i);
				moveSet[3] = a.get(i + 1);
				int moveValue = min(b.simulateMove(moveSet), depth - 1, alpha, beta);
				alpha = (int) Math.max(alpha, moveValue);
				if (alpha >= beta) {
					System.out.println("Pruned count: "+counter); counter++; return alpha;
				}

			}
		}
		return alpha;
	}
	//minimizer (black)
	private static int min(Board b, int depth, int alpha, int beta) {
		if (depth == 0 || Math.abs(b.getSum()) > 999990) {
			return b.getSum();
		}
		ArrayList<ArrayList<Integer>> coloredMoves = b.getAllMoves(false);
		for (int k = 0; k < coloredMoves.size(); k++) {
			ArrayList<Integer> a = coloredMoves.get(k);
			for (int i = 0; i < a.size() - 1; i += 2) {
				int[] moveSet = new int[4];moveSet[0] = a.get(0);moveSet[1] = a.get(1);moveSet[2] = a.get(i);moveSet[3] = a.get(i + 1);
				int moveValue = max(b.simulateMove(moveSet), depth - 1, alpha, beta);
				beta = (int) Math.min(beta, moveValue);
				if (alpha >= beta) {
					System.out.println("Pruned counter: "+counter); counter++; return beta; 
				}
			}
		}
		return beta;
	}
}
