
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineItemTest {
	
	VendingMachineItem vendItem1, vendItem2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vendItem1 = new VendingMachineItem("Chips", 2.00);
		vendItem2 = new VendingMachineItem("Gatorade", 1.75);
	}
	
	@Test
	public void testGetName() {
		
		String result1 = vendItem1.getName();
		assertEquals("Chips", result1);
		
		String result2 = vendItem2.getName();
		assertEquals("Gatorade", result2);
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		vendItem1 = null;
		vendItem2 = null;
	}
/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

}
