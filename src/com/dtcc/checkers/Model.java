package com.dtcc.checkers;

public class Model {

    public String[][] update(Move move){
        return  null;
    }

    public String[][] getBoard() {
        	String [][]board=new String[8][8];
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
