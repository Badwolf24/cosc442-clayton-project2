package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest{
	@Before
	public void setUp() throws Exception {
		VendingMachine vend1 = new VendingMachine();
	}
	
	@Test
	public void testAddItem(){
		 VendingMachine v = new VendingMachine();
		 VendingMachineItem test = new VendingMachineItem("Gum", 1.25);
		 v.addItem(test, "B");
		 assertEquals(test, v.getItem("B"));
	}
	
	@Test
	public void testRemoveItem(){
		 VendingMachine v = new VendingMachine();
		 VendingMachineItem test = new VendingMachineItem("Kit-Kat", 1.55);
		 v.addItem(test, "B");
		 v.removeItem("B");
		 assertEquals(null, v.getItem("B"));
	}
	
	
	@Test
	public void testInsertMoney() {
		VendingMachine v = new VendingMachine();
		v.insertMoney(4.00);
		assertEquals(4.00, v.balance, 0.0001);
	}
	
	@Test
	public void testGetBalance() {
		VendingMachine v = new VendingMachine();
		assertEquals(0, v.getBalance(), 0.0001);
		
		v.insertMoney(1.00);
		assertEquals(1, v.getBalance(), 0.0001);
	}
	
	
	@Test
	public void testMakePurchase() {
		VendingMachine v = new VendingMachine();
		
		//false
		assertEquals(false, v.makePurchase("A"));
		
		//will fail
		v.insertMoney(1.00);
		VendingMachineItem test = new VendingMachineItem("Salted Trail Mix", 1.50); 
		v.addItem(test, "A");
		assertEquals(false, v.makePurchase("A"));
		
		//true
		v.insertMoney(1.00); 
		//still buying 1.50 trail mix, but now with 2 dollars
		//additionally I should note that the level of unsalted trail mix in the York Building is ridiculous
		assertEquals(true, v.makePurchase("A"));
		
		//balance zero, will fail 
		assertEquals(false, v.makePurchase("A"));
		
	}
	
	@Test
	public void returnChange() {
		VendingMachine v = new VendingMachine();
		
		//no balance
		assertEquals(0, v.returnChange(), 0.0001);
		
		//2 dollars added, 1.50 worth of food selected
		VendingMachineItem test = new VendingMachineItem("Fruit Snacks", 1.25);
		v.addItem(test, "A");
		v.insertMoney(2.00);
		v.makePurchase("A");
		assertEquals(0.75, v.returnChange(), 0.0001);
		
		
		
	}
	
	@After
	public void tearDown() throws Exception {
	
	}
	
	
	
}