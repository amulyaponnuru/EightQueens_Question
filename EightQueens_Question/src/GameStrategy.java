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

