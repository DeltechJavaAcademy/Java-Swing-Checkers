package com.dtcc.checkers;

public class Utility {

	public static char player;
	public static void print2DArray(String[][] board) {
		
		for(int i=0;i<board.length;i++)
		{
			for(int j =0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------------------------");
		
	}
	
	public static boolean checkProperMove(Move move,String[][] board)
	{
		boolean isProper=true;
		if(Utility.getPlayer()== board[move.startY][move.startX].charAt(0))
		{
			if(board[move.startY][move.startX].charAt(0)=='R') 
			{
				System.out.println("It is other player's turn : Select Black piece."); isProper=false;
			}
			else 
			{
				System.out.println("It is other player's turn : Select Red piece."); isProper=false;
			}	
		}
		//pawn moving in same column.
		else if(move.endX - move.startX==0 && (move.endY>=0 && move.endY<=7)){isProper=false; }
		//else if(board[move.startY][move.startX]) {return false;} //STILL HAVE TO WORK : MORE ILLEGAL moves.
		else if(move.endY-move.startY >=3 )	//more than 2 squares move. 
		{
			System.out.println("Pawn can not take  3 or more squares jump.");
			isProper=false;
		}
		else if(board[move.startY][move.startX].equals("R-P") && move.endY <move.startY )	//Red pawn can not move backward
		{
			System.out.println("Red pawn can not go backward");
			isProper=false;
		}
		else if(board[move.startY][move.startX].equals("B-P") && move.endY > move.startY )	//Black pawn can not move backward
		{
			System.out.println("Black pawn can not go backward");
			isProper=false;
		}
		else if(!(board[move.endY][move.endX].equals("EMPTY")))	//if square already contains a pawn.
		{
			System.out.println("Pawn is present.");
			return false;
		}
		else if(move.endY - move.startY== 2 )	//Red pawn can not jump over same red color pawn.
		{
			int x=move.startX;
			int y =move.endX;
			if(y-x==2) 
			{
				if(board[move.startY][move.startX].charAt(0)=='R' && board[(move.startY)+1][(move.startX)+1].charAt(0)=='R')
				{
					System.out.println("Red pawn can not jump over same red color pawn...(right side move)"); return false;
				}
			}
			if(y-x==-2) 
			{
				if(board[move.startY][move.startX].charAt(0)=='R' && board[(move.startY)+1][(move.startX)-1].charAt(0)=='R')
				{
					System.out.println("Red pawn can not jump over same red color pawn...(left side move)");return false;	
				}
			}
		}
		else if(move.endY - move.startY== -2 )	//Black pawn can jump over same black color pawn.
		{
			
			int startx=move.startX;
			int endx =move.endX;
			if(endx-startx==2) 
			{
				if(board[move.startY][move.startX].charAt(0)=='B' && board[(move.startY)-1][(move.startX)+1].charAt(0)=='B')
				{
					System.out.println("Black pawn can not jump over same black color pawn....(right side move)"); return false;
				}
			}
			if(endx-startx==-2) 
			{
				if(board[move.startY][move.startX].charAt(0)=='B' && board[(move.startY)-1][(move.startX)-1].charAt(0)=='B')
				{
					System.out.println("Black pawn can not jump over same black color pawn...(left side move)"); return false;
				}
			}
		}
		else
		{
			isProper=true;
		}
		return isProper;
	}
	
	public static void setPlayer(char p)
	{
		player=p;
	}
	
	public static char getPlayer()
	{
		return player; 
	}
}
}

