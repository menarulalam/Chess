import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	private int board[][];
	private boolean wrc;
	private boolean wlc;
	private boolean blc;
	private boolean brc;
	private ArrayList<Integer> removedPieces;
	private ArrayList<Integer> moveList;
	public static final int[][] WHITE_PAWN_TABLE={{ 0,  0,  0,  0,  0,  0,  0, 0},{
			50, 50, 50, 50, 50, 50, 50, 50},{
			10, 10, 20, 30, 30, 20, 10, 10},{
			 5,  5, 10, 25, 25, 10,  5,  5},{
			 0,  0,  0, 20, 20,  0,  0,  0},{
			 5, -5,-10,  0,  0,-10, -5,  5},{
			 5, 10, 10,-20,-20, 10, 10,  5},{
			 0,  0,  0,  0,  0,  0,  0,  0}};
	public static final int[][] WHITE_KNIGHT_TABLE= {{-50,-40,-30,-30,-30,-30,-40,-50},{
			-40,-20,  0,  0,  0,  0,-20,-40},{
			-30,  0, 10, 15, 15, 10,  0,-30},{
			-30,  5, 15, 20, 20, 15,  5,-30},{
			-30,  0, 15, 20, 20, 15,  0,-30},{
			-30,  5, 10, 15, 15, 10,  5,-30},{
			-40,-20,  0,  5,  5,  0,-20,-40},{
			-50,-40,-30,-30,-30,-30,-40,-50}};
	public static final int[][] WHITE_BISHOP_TABLE = {{-20,-10,-10,-10,-10,-10,-10,-20},{
		-10,  0,  0,  0,  0,  0,  0,-10},{
		-10,  0,  5, 10, 10,  5,  0,-10},{
		-10,  5,  5, 10, 10,  5,  5,-10},{
		-10,  0, 10, 10, 10, 10,  0,-10},{
		-10, 10, 10, 10, 10, 10, 10,-10},{
		-10,  5,  0,  0,  0,  0,  5,-10},{
		-20,-10,-10,-10,-10,-10,-10,-20}};
	public static final int[][] WHITE_ROOK_TABLE = {{  0,  0,  0,  0,  0,  0,  0,  0},{
		  5, 10, 10, 10, 10, 10, 10,  5},{
		  -5,  0,  0,  0,  0,  0,  0, -5},{
		  -5,  0,  0,  0,  0,  0,  0, -5},{
		  -5,  0,  0,  0,  0,  0,  0, -5},{
		  -5,  0,  0,  0,  0,  0,  0, -5},{
		  -5,  0,  0,  0,  0,  0,  0, -5},{
		   0,  0,  0,  5,  5,  0,  0,  0}};
	public static final int[][] WHITE_QUEEN_TABLE = {{-20,-10,-10, -5, -5,-10,-10,-20},{
		-10,  0,  0,  0,  0,  0,  0,-10},{
		-10,  0,  5,  5,  5,  5,  0,-10},{
		 -5,  0,  5,  5,  5,  5,  0, -5},{
		  0,  0,  5,  5,  5,  5,  0, -5},{
		-10,  5,  5,  5,  5,  5,  0,-10},{
		-10,  0,  5,  0,  0,  0,  0,-10},{
		-20,-10,-10, -5, -5,-10,-10,-20}};
	public static final int[][] WHITE_KING_TABLE = {{-30,-40,-40,-50,-50,-40,-40,-30},{
		-30,-40,-40,-50,-50,-40,-40,-30},{
		-30,-40,-40,-50,-50,-40,-40,-30},{
		-30,-40,-40,-50,-50,-40,-40,-30},{
		-20,-30,-30,-40,-40,-30,-30,-20},{
		-10,-20,-20,-20,-20,-20,-20,-10},{
		 20, 20,  0,  0,  0,  0, 20, 20},{
		 20, 30, 10,  0,  0, 10, 30, 20}};
	
	public Board() {
		wrc = true;
		blc = true;
		brc = true;
		wlc = true;
		removedPieces = new ArrayList<Integer>();
		moveList = new ArrayList<Integer>();
		board = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				board[i][j] = 0;
		}
		for (int i = 0; i < 8; i++) {
			board[1][i] = -10;
			board[6][i] = 10;

		}
		board[0][0] = -50;
		board[0][7] = -50;
		board[7][0] = 50;
		board[7][7] = 50;
		board[0][1] = -30;
		board[0][6] = -30;
		board[0][2] = -31;
		board[0][5] = -31;
		board[0][3] = -90;
		board[0][4] = -99999;

		board[7][1] = 30;
		board[7][6] = 30;
		board[7][2] = 31;
		board[7][5] = 31;
		board[7][3] = 90;
		board[7][4] = 99999;

	}
	public void setSquare(int i, int j, int value)
	{
		board[i][j]=value;
	}
	public boolean isWrc() {
		return wrc;
	}

	public void setWrc(boolean wrc) {
		this.wrc = wrc;
	}

	public boolean isWlc() {
		return wlc;
	}

	public void setWlc(boolean wlc) {
		this.wlc = wlc;
	}

	public boolean isBlc() {
		return blc;
	}

	public void setBlc(boolean blc) {
		this.blc = blc;
	}

	public boolean isBrc() {
		return brc;
	}

	public void setBrc(boolean brc) {
		this.brc = brc;
	}

	public void setBoard(int[][] a) {
		board = a;
	}

	public int[][] getBoard() {
		return board;
	}

	public Board deepClone() {

		Board ans = new Board();
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				ans.setSquare(i, j, board[i][j]);
			}
		}
		ans.setBrc(this.brc);
		ans.setWrc(this.wrc);
		ans.setBlc(this.blc);
		ans.setWlc(this.wlc);
		ans.setrP(new ArrayList<Integer>(this.removedPieces));
		ans.setmL(new ArrayList<Integer>(this.moveList));
		return ans;

	}

	public void setrP(ArrayList<Integer> a) {
		removedPieces = a;
	}

	public void setmL(ArrayList<Integer> a) {
		moveList = a;
	}

	public int[] getLastMove() {
		if (moveList.size() >= 4)
			return new int[] { moveList.get(moveList.size() - 4), moveList.get(moveList.size() - 3),
					moveList.get(moveList.size() - 2), moveList.get(moveList.size() - 1) };
		return new int[] { 0, 0, 0, 0 };
	}

	public static String getName(int a) {
		int b = Math.abs(a);
		if (b == 0) {
			return "_______________";
		}
		String ans = "";
		if (b < 0) {
			ans += "black ";
		} else {
			ans += "white ";
		}
		if (b == 10)
			ans += "pawn";
		if (b == 31) {
			ans += "bishop";
		}
		if (b == 30) {
			ans += "knight";
		}
		if (b == 50) {
			ans += "rook";
		}
		if (b == 90) {
			ans += "queen";
		}
		if (b == 99999) {
			ans += "King";
		}
		return ans;
	}

	public ArrayList<Integer> getMoveList() {
		return moveList;
	}

	public ArrayList<Integer> getRemovedPieces() {
		return removedPieces;
	}

	public Board simulateMove(int a, int b, int c, int d) {
		Board bc = this.deepClone();
		bc.move(a, b, c, d);
		return bc;

	}

	public Board simulateMove(int[] moveset) {
		if (moveset.length == 4)
			return simulateMove(moveset[0], moveset[1], moveset[2], moveset[3]);
		else {
			return simulateMove(moveset[1], moveset[2], moveset[3], moveset[4]);

		}
	}

	public void move(int a, int b, int c, int d) {
		if (isValid(a, b) && isValid(c, d)) {
			if (blackCanLeftCastle() && a == 0 && b == 4 && c == 0 && d == 2) {
				move(0, 0, 0, 3);
				board[c][d] = board[a][b];
				board[a][b] = 0;
				removedPieces.add(0);
				moveList.add(a);
				moveList.add(b);
				moveList.add(c);
				moveList.add(d);
				blc = false;
				brc = false;
				return;
			}
			if (blackCanRightCastle() && a == 0 && b == 4 && c == 0 && d == 6) {
				move(0, 7, 0, 5);
				board[c][d] = board[a][b];
				board[a][b] = 0;
				removedPieces.add(0);
				moveList.add(a);
				moveList.add(b);
				moveList.add(c);
				moveList.add(d);
				blc = false;
				brc = false;
				return;
			}
			if (whiteCanLeftCastle() && a == 7 && b == 4 && c == 7 && d == 2) {
				move(7, 0, 7, 3);
				board[c][d] = board[a][b];
				board[a][b] = 0;
				removedPieces.add(0);
				moveList.add(a);
				moveList.add(b);
				moveList.add(c);
				moveList.add(d);
				wlc = false;
				wrc = false;
				return;
			}
			if (whiteCanRightCastle() && a == 7 && b == 4 && c == 7 && d == 6) {
				move(7, 7, 7, 5);
				board[c][d] = board[a][b];
				board[a][b] = 0;
				removedPieces.add(0);
				moveList.add(a);
				moveList.add(b);
				moveList.add(c);
				moveList.add(d);
				wlc = false;
				wrc = false;
				return;
			}

			removedPieces.add(board[c][d]);
			if (c == 7 && board[a][b] == -10) {
				board[c][d] = -90;
				board[a][b] = 0;
				removedPieces.add(-10);
				moveList.add(a);
				moveList.add(b);
				moveList.add(-1);
				moveList.add(d);
				return;
			}
			if (c == 0 && board[a][b] == 10) {
				board[c][d] = 90;
				board[a][b] = 0;
				removedPieces.add(10);
				moveList.add(a);
				moveList.add(b);
				moveList.add(-1);
				moveList.add(d);
				return;
			}
			if (board[a][b] * board[c][d] <= 0) {
				board[c][d] = board[a][b];
				board[a][b] = 0;
				if (board[c][d] > 200) {

					wrc = false;
					wlc = false;
				}
				if (board[c][d] < -200) {

					brc = false;
					blc = false;
				}
				if ((a == 7 && b == 7) || (c == 7 && d == 7)) {
					wrc = false;
				}
				if ((a == 7 && b == 0) || (c == 7 && d == 0)) {
					wlc = false;
				}
				if ((a == 0 && b == 7) || (c == 0 && d == 7)) {
					brc = false;
				}
				if ((a == 0 && b == 0) || (c == 0 && d == 0)) {
					blc = false;
				}

				moveList.add(a);
				moveList.add(b);
				moveList.add(c);
				moveList.add(d);
			}
		}
	}

	public void undo() {
		if (moveList.size() >= 4) {
			int a = moveList.get(moveList.size() - 4);
			int b = moveList.get(moveList.size() - 3);
			int c = moveList.get(moveList.size() - 2);
			int d = moveList.get(moveList.size() - 1);
			if (c == -1) {
				board[a][b] = removedPieces.remove(removedPieces.size() - 1);
				if (isWhite(a, b)) {
					board[0][d] = removedPieces.remove(removedPieces.size() - 1);
				} else {
					board[7][d] = removedPieces.remove(removedPieces.size() - 1);

				}
				for (int i = 0; i < 4; i++) {
					moveList.remove(moveList.size() - 1);
				}
				return;

			} else if (moveList.size() >= 4) {
				board[a][b] = board[c][d];
				if (removedPieces.size() != 0)
					board[c][d] = removedPieces.remove(removedPieces.size() - 1);
				if (a == 0 && b == 4 && c == 0 && d == 2) {
					blc = true;
					for (int i = 0; i < 4; i++) {
						moveList.remove(moveList.size() - 1);
					}
					undo();
				}
				if (a == 0 && b == 4 && c == 0 && d == 6) {
					brc = true;
					for (int i = 0; i < 4; i++) {
						moveList.remove(moveList.size() - 1);
					}
					undo();
				}
				if (a == 7 && b == 4 && c == 7 && d == 2) {
					wlc = true;
					for (int i = 0; i < 4; i++) {
						moveList.remove(moveList.size() - 1);
					}
					undo();
				}
				if (a == 7 && b == 4 && c == 7 && d == 6) {
					wrc = true;
					for (int i = 0; i < 4; i++) {
						moveList.remove(moveList.size() - 1);
					}
					undo();
				}
			}
			for (int i = 0; i < 4; i++) {
				moveList.remove(moveList.size() - 1);
			}
		}
	}

	public void printBoard() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				String k = " ";
				if (isBlack(i, j)) {
					k = "*";
				}
				System.out.print(" " + k + getName(board[i][j]).substring(6, 7) + " ");
			}
			System.out.println("");
			System.out.println(" ");
		}
	}

	// TODO add castling
	public boolean blackCanLeftCastle() {
		boolean empty = true;
		for (int i = 3; i > 0; i--) {
			if (board[0][i] != 0) {
				empty = false;
			}
		}
		if (blc && empty) {
			return true;
		}
		return false;
	}

	public boolean blackCanRightCastle() {
		boolean empty = true;
		for (int i = 5; i < 7; i++) {
			if (board[0][i] != 0) {
				empty = false;
			}
		}
		if (brc && empty) {
			return true;
		}
		return false;
	}

	public boolean whiteCanRightCastle() {
		boolean empty = true;
		for (int i = 5; i < 7; i++) {
			if (board[7][i] != 0) {
				empty = false;
			}
		}
		if (wrc && empty) {
			return true;
		}
		return false;
	}

	public boolean whiteCanLeftCastle() {
		boolean empty = true;
		for (int i = 3; i > 0; i--) {
			if (board[7][i] != 0) {
				empty = false;
			}
		}
		if (wlc && empty) {
			return true;
		}
		return false;
	}

	public ArrayList<Integer> getMoves(int a, int b) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (isValid(a, b))
			ans.add(a);
		ans.add(b);
		int p = Math.abs(board[a][b]);
		if (isWhite(a, b)) {
			switch (p) {
			case 10: {
				if (a != 0 && board[a - 1][b] == 0) {
					a(ans, a - 1, b, 0);
					if (a == 6 && board[a - 2][b] == 0) {

						a(ans, a - 2, b, 0);
					}
				}

				if (isValid(a - 1, b - 1) && isBlack(a - 1, b - 1))
					a(ans, a - 1, b - 1, 0);
				if (isValid(a - 1, b + 1) && isBlack(a - 1, b + 1))
					a(ans, a - 1, b + 1, 0);
				break;
			}

			case 31: {

				for (int i = 1; i + a < 8 && b + i < 8; i++) {
					if (a(ans, a + i, b + i, 0) != 1) {
						break;
					}
				}

				for (int i = 1; a + i < 8 && b - i >= 0; i++) {
					if (a(ans, a + i, b - i, 0) != 1) {
						break;
					}
				}

				for (int i = 1; a - i >= 0 && b - i >= 0; i++) {
					if (a(ans, a - i, b - i, 0) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0 && b + i < 8; i++) {
					if (a(ans, a - i, b + i, 0) != 1) {
						break;
					}
				}
				break;
			}

			case 30: {
				a(ans, a + 2, b - 1, 0);
				a(ans, a + 2, b + 1, 0);
				a(ans, a - 2, b + 1, 0);
				a(ans, a - 2, b - 1, 0);
				a(ans, a + 1, b - 2, 0);
				a(ans, a - 1, b - 2, 0);
				a(ans, a + 1, b + 2, 0);
				a(ans, a - 1, b + 2, 0);
				break;
			}
			case 50: {

				for (int i = 1; a + i < 8; i++) {
					if (a(ans, a + i, b, 0) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0; i++) {
					if (a(ans, a - i, b, 0) != 1) {
						break;
					}
				}
				for (int i = 1; b + i < 8; i++) {
					if (a(ans, a, b + i, 0) != 1) {
						break;
					}
				}
				for (int i = 1; b - i >= 0; i++) {
					if (a(ans, a, b - i, 0) != 1) {
						break;
					}
				}
				break;
			}
			case 90: {
				for (int i = 1; i + a < 8 && b + i < 8; i++) {
					if (a(ans, a + i, b + i, 0) != 1) {
						break;
					}
				}

				for (int i = 1; a + i < 8 && b - i >= 0; i++) {
					if (a(ans, a + i, b - i, 0) != 1) {
						break;
					}
				}

				for (int i = 1; a - i >= 0 && b - i >= 0; i++) {
					if (a(ans, a - i, b - i, 0) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0 && b + i < 8; i++) {
					if (a(ans, a - i, b + i, 0) != 1) {
						break;
					}
				}

				for (int i = 1; a + i < 8; i++) {
					if (a(ans, a + i, b, 0) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0; i++) {
					if (a(ans, a - i, b, 0) != 1) {
						break;
					}
				}
				for (int i = 1; b + i < 8; i++) {
					if (a(ans, a, b + i, 0) != 1) {
						break;
					}
				}
				for (int i = 1; b - i >= 0; i++) {
					if (a(ans, a, b - i, 0) != 1) {
						break;
					}

				}
				break;
			}
			case 99999: {
				a(ans, a + 1, b + 1, 0);
				a(ans, a + 1, b - 1, 0);
				a(ans, a + 1, b, 0);
				a(ans, a, b + 1, 0);
				a(ans, a, b - 1, 0);
				a(ans, a - 1, b + 1, 0);
				a(ans, a - 1, b - 1, 0);
				a(ans, a - 1, b, 0);
				if (whiteCanLeftCastle())
					a(ans, 7, 2, 0);
				if (whiteCanRightCastle())
					a(ans, 7, 6, 0);
				break;
			}
			default:
				break;
			}

		}

		else {
			switch (p) {
			case 10: {
				if (a != 7 && board[a + 1][b] == 0) {
					a(ans, a + 1, b, 1);
					if (a == 1 && board[a + 2][b] == 0) {

						a(ans, a + 2, b, 1);
					}
				}

				if (isValid(a + 1, b - 1) && isWhite(a + 1, b - 1))
					a(ans, a + 1, b - 1, 1);
				if (isValid(a + 1, b + 1) && isWhite(a + 1, b + 1))
					a(ans, a + 1, b + 1, 1);
				break;
			}
			case 31: {
				for (int i = 1; i + a < 8 && b + i < 8; i++) {
					if (a(ans, a + i, b + i, 1) != 1) {
						break;
					}
				}

				for (int i = 1; a + i < 8 && b - i >= 0; i++) {
					if (a(ans, a + i, b - i, 1) != 1) {
						break;
					}
				}

				for (int i = 1; a - i >= 0 && b - i >= 0; i++) {
					if (a(ans, a - i, b - i, 1) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0 && b + i < 8; i++) {
					if (a(ans, a - i, b + i, 1) != 1) {
						break;
					}
				}
				break;
			}

			case 30:
				a(ans, a + 2, b - 1, 1);
				a(ans, a + 2, b + 1, 1);
				a(ans, a - 2, b + 1, 1);
				a(ans, a - 2, b - 1, 1);
				a(ans, a + 1, b - 2, 1);
				a(ans, a - 1, b - 2, 1);
				a(ans, a + 1, b + 2, 1);
				a(ans, a - 1, b + 2, 1);
				break;
			case 50: {

				for (int i = 1; a + i < 8; i++) {
					if (a(ans, a + i, b, 1) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0; i++) {
					if (a(ans, a - i, b, 1) != 1) {
						break;
					}
				}
				for (int i = 1; b + i < 8; i++) {
					if (a(ans, a, b + i, 1) != 1) {
						break;
					}
				}
				for (int i = 1; b - i >= 0; i++) {
					if (a(ans, a, b - i, 1) != 1) {
						break;
					}
				}
				break;
			}
			case 90: {
				for (int i = 1; a + i < 8; i++) {
					if (a(ans, a + i, b, 1) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0; i++) {
					if (a(ans, a - i, b, 1) != 1) {
						break;
					}
				}
				for (int i = 1; b + i < 8; i++) {
					if (a(ans, a, b + i, 1) != 1) {
						break;
					}
				}
				for (int i = 1; b - i >= 0; i++) {
					if (a(ans, a, b - i, 1) != 1) {
						break;
					}
				}

				for (int i = 1; i + a < 8 && b + i < 8; i++) {
					if (a(ans, a + i, b + i, 1) != 1) {
						break;
					}
				}

				for (int i = 1; a + i < 8 && b - i >= 0; i++) {
					if (a(ans, a + i, b - i, 1) != 1) {
						break;
					}
				}

				for (int i = 1; a - i >= 0 && b - i >= 0; i++) {
					if (a(ans, a - i, b - i, 1) != 1) {
						break;
					}
				}
				for (int i = 1; a - i >= 0 && b + i < 8; i++) {
					if (a(ans, a - i, b + i, 1) != 1) {
						break;
					}
				}
				break;
			}
			case 99999: {
				a(ans, a + 1, b + 1, 1);
				a(ans, a + 1, b - 1, 1);
				a(ans, a + 1, b, 1);
				a(ans, a, b + 1, 1);
				a(ans, a, b - 1, 1);
				a(ans, a - 1, b + 1, 1);
				a(ans, a - 1, b - 1, 1);
				a(ans, a - 1, b, 1);
				if (blackCanLeftCastle())
					a(ans, 0, 2, 1);
				if (blackCanRightCastle())
					a(ans, 0, 6, 1);
				break;
			}
			default:

				break;
			}
		}
		return ans;
	}

	public int a(ArrayList<Integer> a, int b, int c, int d) {
		if (isValid(b, c)) {
			if (board[b][c] == 0) {
				a.add(b);
				a.add(c);
				return 1; // Verifies that the possible move is an empty space
			}
			if (d == 0) {
				if (isBlack(b, c)) {
					a.add(b);
					a.add(c);
					return 2; // Verifies that the possible move is a capture
				}
			}
			if (d == 1) {
				if (isWhite(b, c)) {
					a.add(b);
					a.add(c);
					return 2; // Verifies that the possible move is a capture

				}
			}
		}
		return 0;
	}

	public void move(int[] moveset) {
		if (moveset.length == 4)
			move(moveset[0], moveset[1], moveset[2], moveset[3]);
		if (moveset.length == 5)
			move(moveset[1], moveset[2], moveset[3], moveset[4]);

	}

	public boolean isWhite(int a, int b) {
		return board[a][b] > 0;
	}

	public boolean isBlack(int a, int b) {
		return board[a][b] < 0;
	}
	public int getSquare(int i, int j)
	{
		return board[i][j];
	}
	public boolean blackCanMove(int [] moveset)
	{
		ArrayList<ArrayList<Integer>> blackMoves=getAllMoves(false);
		for (ArrayList<Integer> a: blackMoves)
		{
			for (int i=2; i<a.size()-1; i+=2)
			{
				int[] legalMove={a.get(0), a.get(1), a.get(i), a.get(i+1)};
				if (Arrays.equals(moveset, legalMove))
				{
					return true;
				}
			}
		}
		return false;
	}
	public int getSum() {
		return dynamicEvaluation();
	}

	public static boolean isValid(int a, int b) {
		return (a >= 0 && a < 8 && b >= 0 && b < 8);
	}

	public ArrayList<ArrayList<Integer>> getAllMoves(boolean isWhite) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (isWhite) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (isWhite(i, j)) {
						ArrayList<Integer> moves = getMoves(i, j);
						if (moves.size() > 2) {
							ans.add(moves);
						}
					}

				}
			}
		} else {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (isBlack(i, j)) {
						ArrayList<Integer> moves = getMoves(i, j);
						if (moves.size() > 2) {
							ans.add(moves);
						}
					}
				}
			}

		}
		return ans;

	}

	public int dynamicEvaluation() {
		int sum=0;
		int wb=0;
		int bb=0;
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				switch(board[i][j]) {
				case 10: sum+=100; sum+=WHITE_PAWN_TABLE[i][j]; break;
				case 30: sum+=300; sum+=WHITE_KNIGHT_TABLE[i][j]; break;
				case 31: sum+=310; sum+=WHITE_BISHOP_TABLE[i][j]; wb++; break;
				case 50: sum+=500; sum+=WHITE_ROOK_TABLE[i][j]; break;
				case 90: sum+=900; sum+=WHITE_QUEEN_TABLE[i][j]; break;
				case 99999: sum+=999990; sum+=WHITE_KING_TABLE[i][j]; break;
				case -10: sum+=-100; sum-=WHITE_PAWN_TABLE[7-i][j]; break;
				case -30: sum+=-300; sum-=WHITE_KNIGHT_TABLE[7-i][j]; break;
				case -31: sum+=-310; sum-=WHITE_BISHOP_TABLE[7-i][j]; bb++; break;
				case -50: sum+=-500; sum-=WHITE_ROOK_TABLE[7-i][j]; break;
				case -90: sum+=-900; sum-=WHITE_QUEEN_TABLE[7-i][j]; break;
				case -99999: sum+=-999990; sum-=WHITE_KING_TABLE[7-i][j]; break;
				default: break;}
			}
		}
		if (wb==2)
		{
			sum+=50;
		}
		if (bb==2)
		{
			sum-=50;
		}
		return sum;
	}
}
