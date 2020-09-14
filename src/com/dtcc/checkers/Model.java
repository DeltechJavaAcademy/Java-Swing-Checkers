package com.dtcc.checkers;

public class Model {
	
	String [][]board=new String[8][8];
	
    public String[][] update(Move move){
    	if(!Utility.checkProperMove(move,board)) {return board;}
    	else
    	{
    	Utility.setPlayer(board[move.startY][move.startX].charAt(0));
    	//one diagonal move.
    	
    	if(move.endY - move.startY==1 || move.endY -move.startY == -1)
    	{
	    	if(board[move.startY][move.startX].equals("R-P"))
	    	{
	    		board[move.startY][move.startX]="EMPTY";
	        	board[move.endY][move.endX]="R-P";
	    	}
	    	else if(board[move.startY][move.startX].equals("B-P"))
	    	{
	    		board[move.startY][move.startX]="EMPTY";
	        	board[move.endY][move.endX]="B-P";
	    	}
	    	else if(board[move.startY][move.startX].equals("R-K"))
	    	{
	    		board[move.startY][move.startX]="EMPTY";
	        	board[move.endY][move.endX]="R-K";
	    	}
	    	else if(board[move.startY][move.startX].equals("B-K"))
	    	{
	    		board[move.startY][move.startX]="EMPTY";
	        	board[move.endY][move.endX]="B-K";
	    	}
    	}
    	
    	//if a pawn jumps over other pawn.
    	else if(move.endY - move.startY== 2 || move.endY -move.startY == -2)
    	{
    		int newRow=(move.endY + move.startY) / 2;
    		int newCol= (move.endX + move.startX) / 2;
    		board[newRow][newCol]="EMPTY";
    		
    		if(board[move.startY][move.startX].equals("R-P")) 
	        { 
    			board[move.endY][move.endX]="R-P";
    			board[move.startY][move.startX]="EMPTY";
	        }
	    	else if(board[move.startY][move.startX].equals("B-P")) 
	        {	
	    		board[move.endY][move.endX]="B-P";
	    		board[move.startY][move.startX]="EMPTY";
	        }
	    	else if(board[move.startY][move.startX].equals("R-K")) 
	        { 
    			board[move.endY][move.endX]="R-K";
    			board[move.startY][move.startX]="EMPTY";
	        }
	    	else if(board[move.startY][move.startX].equals("B-K")) 
	        { 
    			board[move.endY][move.endX]="B-K";
    			board[move.startY][move.startX]="EMPTY";
	        }
    	}
    	
    	//Black pawn turns black king
    	if (move.endY == 0 && board[move.endY][move.endX].charAt(0) =='B' )
            //board[move.startY][move.startX] = "B-K";
    		board[move.endY][move.endX] = "B-K";
    	
    	//Red pawn turns red King
        if (move.endY == 7 &&board[move.endY][move.endX].charAt(0) =='R')
        	//board[move.startY][move.startX] = "R-K";
        	board[move.endY][move.endX] = "R-K";

    	return board;
    	}
    }

    public String[][] getBoard() {
        		//board=new String[8][8];
        	     for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        if (row % 2 != col % 2 ) {
                            if (row < 3)
                                board[row][col] = "R-P";
                            else if (row > 4)
                                board[row][col] = "B-P";
                            else
                                board[row][col] = "EMPTY";
                        }
                        else {
                            board[row][col] = "EMPTY";
                        }
                    }
                }
        	return board;
    }
    
    public void save(){}

    public void load(){}
}
