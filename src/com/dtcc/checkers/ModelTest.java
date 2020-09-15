package com.dtcc.checkers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelTest {
	
	Model model;
	@BeforeEach
	public void setUp() {
	model = new Model();
	}
	@Test
	public void getBoradTest() {
		 String[][] expected = new String[8][8];
		 assertEquals(expected.length,model.getBoard().length);
	}
	@Test
	public void getBoradIndexTest() {
		 String expected = "R-P";
		String[][] actual = model.getBoard();
		 assertEquals(expected, actual[1][2]);
	}
	@Test
	public void getBoradIndexLastTest() {
		 String expected = "B-P";
		String[][] actual = model.getBoard();
		 assertEquals(expected, actual[7][4]);
	}
//	@Test
//	public void saveFileTest() {
//		model.save();
//		
//		
//		
//	}

}