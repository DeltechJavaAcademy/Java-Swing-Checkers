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
//		model.getBoard();
		 assertEquals(expected.length,model.getBoard().length);
	}
	@Test
	public void getBoradIndexTest() {
		//Model model = new Model();
		 String expected = "R-P";
		String[][] actual = model.getBoard();
		 assertEquals(expected, actual[1][2]);
	}
//	@Test
//	public void saveFileTest() {
//		model.save();
//		
//		
//		
//	}

}