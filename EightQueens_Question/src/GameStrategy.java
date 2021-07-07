public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		return cellId % 8;
	}

	private int getRow(int cellId) {
		return cellId / 8;
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if (numQueens == 8)
			throw new GameOverException(); 

		int col = getColumn(cellId);

		int row = getRow(cellId);
		// check if any queen is present in the row or column, 
		//if present, invalid move
		for (int i = 0; i < 8; i++) {
			if (placedQueens[row][i] == true || placedQueens[i][col] == true) {
				return false;
			}
		}

		// check for diagonal queens
		int i = row;
		int j = col;
		// upper negative diagonal
		while (i >= 0 && j >= 0) {
			if (placedQueens[i--][j--] == true) {
				return false;
			}
		}
		i = row;
		j = col;
		// lower negative diagonal
		while (i <= 7 && j <= 7) {
			if (placedQueens[i++][j++] == true) {
				return false;
			}
		}
		i = row;
		j = col;
		// upper positive diagonal
		while (i >= 0 && j <= 7) {
			if (placedQueens[i--][j++] == true) {
				return false;
			}
		}
		i = row;
		j = col;
		// lower positive diagonal
		while (i <= 7 && j >= 0) {
			if (placedQueens[i++][j--] == true) {
				return false;
			}
		}
		//
		placedQueens[row][col] = true;
		numQueens++;
		System.out.println("valid");
		return isValid;
	}
}

/**
 * 0 1 2 3 4 5 6 7 0 8 9 10 11 12 13 14 15 1 16 17 18 19 20 21 22 23 2 24 25 26
 * 27 28 29 30 31 3 32 33 34 35 36 37 38 39 4 40 41 42 43 44 45 46 47 5 48 49 50
 * 51 52 53 54 55 6 56 57 58 59 60 61 62 63 7
 * 
 * 
 * arr[2][4]
 * 
 * 
 */
