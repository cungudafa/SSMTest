package com.cungudafa.spingmvc01.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.cungudafa.spingmvc01.util.DBManager;

public class DBManagerTest {
	
	@Test
	public void testCase1(){
		try {
			Connection con = DBManager.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
