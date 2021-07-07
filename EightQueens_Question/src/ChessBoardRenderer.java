public class ChessBoardRenderer {
	public boolean isBlackSquare(int square) {

		// WRITE YOUR LOGIC HERE...
		//if the row number is even, black squares at odd places
		if((square/8)%2==0) {
			if(square%2!=0) {
				return true;
			}
		}
		//if row number is odd, black squares at even places
		else {
			if(square%2==0) {
				return true;
			}
		}
		return false;
	}
}

