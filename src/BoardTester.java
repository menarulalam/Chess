import java.util.ArrayList;

//TODO FIX Board.undo()
public class BoardTester {

	public static void main(String[] args) {
		Board b = new Board();

int[] a1=MiniMax.getComputerMove(b.deepClone(), 4);
for (int c1: a1)
{
	System.out.println(c1);
}
b.move(a1);
b.move(1, 4, 3, 4);
b.printBoard();


	}

}

