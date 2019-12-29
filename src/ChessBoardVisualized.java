
import java.util.*;

public class ChessBoardVisualized {

			
		
	

	public static void main(String[] menarulisthebest) {

		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		board.printBoard();
		for (int i = 0; i < 500; i++) {
			if (Math.abs(board.getSum()) > 99999) {
				System.out.println("Game Over");
				if (board.getSum() > 0) {
					System.out.println("The Computer Wins!");
					break;
				}
				System.out.println("You Won!");
				break;
			}
			if (i==0)
			{
				board.move(6, 3, 4, 3);
				board.printBoard();

			}
			else if (i==1)
			{
				board.move(7, 1, 5, 2);
				board.printBoard();
			}
			else {
				board.move(MiniMax.getComputerMove(board, 6));
				board.printBoard();
			}
			System.out.println("Enter a moveset for black: ");
			int[] moveset = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() };
			while (!board.blackCanMove(moveset)) {
				System.out.println("Invalid move, try again: ");
				moveset = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() };
			}
			board.move(moveset);
			board.printBoard();
			

		}
		sc.close();
	}
}
