package leetcode;

public class TicTacToe {

	public boolean validTicTacToe(String[] board) {
        boolean xFlag = false, oFlag = false;
        

        // make a 3 by 3 array
        char[][] arr = new char[3][3];
        for(int i=0;i<arr.length;i++) arr[i] = board[i].toCharArray();
        
        // count O and X
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < arr.length; i++) for (int j = 0; j < arr.length; j++) {
			if (arr[i][j] == 'X') cnt1++;
			else if (arr[i][j] == 'O') cnt2++;
			else continue;
		}
        
        // check rows
        for (String str : board) {
        	if (str == "XXX") xFlag = true;
        	if (str == "OOO") oFlag = true;
        }
        
        // check pre-conditions
 		if (cnt1 < cnt2 || cnt1-cnt2 > 1 || (xFlag && oFlag)) return false;
 		
 		// check columns
		for (int i = 0; i < arr.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[j][i]);
			}
			if (sb.toString() == "XXX") xFlag = true;
			if (sb.toString() == "OOO") oFlag = true;
		}

        // check diagonals
		if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') xFlag = true;
		if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') xFlag = true;
		
		if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') oFlag = true;
		if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') oFlag = true;
		
		if (xFlag && oFlag) return false;
		
		if (xFlag && cnt1-cnt2 == 0) return false;
		
		if (oFlag && cnt1-cnt2 == 1) return false;

        return true;
    }
	
	public static void main(String[] args) {
		String[] board = new String[] {"XOX","OXX","OOX"}; // "OXX","XOX","OXO"
		System.out.println(new TicTacToe().validTicTacToe(board));
	}
}
