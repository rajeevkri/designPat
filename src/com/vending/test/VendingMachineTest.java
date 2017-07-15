package com.vending.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.vending.BasicVendingMachine;
import com.vending.Container;
import com.vending.Coin;
import com.vending.IVendingMachine;
import com.vending.Item;
import com.vending.InSufficientChangeException;
import com.vending.NotAvailableException;

public class VendingMachineTest {
	
	@Test
	public void testAddItem() {
		BasicVendingMachine vm = new BasicVendingMachine();
		vm.addItem("Red Bull", 85, 5);
		Item item = new Item("Red Bull");
		assertTrue(vm.hasItem(item));
	}
	
	@Test
	public void testBuyItemWithExactPrice() { 
		BasicVendingMachine vm = new BasicVendingMachine();
		long price = vm.getItemPrice(Item.getCoke(), 2); 
		assertEquals(2*Item.getCoke().getPrice(), price); 
		vm.insertCoin(Coin.TEN);
		vm.insertCoin(Coin.TEN);
		vm.insertCoin(Coin.FIVE);
		Container<Item, List<Coin>> bucket = vm.collectItemAndChange(1);
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond(); 
		// should be Coke
		assertEquals(Item.getCoke(), item); 
		// there should not be any change
		assertTrue(change.isEmpty());
	}

	@Test
	public void testBuyItemWithMorePrice() {
		BasicVendingMachine vm = new BasicVendingMachine();
		long price = vm.getItemPrice(Item.getSoda(), 2);
		assertEquals(2*Item.getSoda().getPrice(), price);
		vm.insertCoin(Coin.TEN);
		vm.insertCoin(Coin.TEN);
		vm.insertCoin(Coin.TEN);
		vm.insertCoin(Coin.TEN);
		vm.insertCoin(Coin.TEN);
		Container<Item, List<Coin>> bucket = vm.collectItemAndChange(1);
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();
		// should be Coke
		assertEquals(Item.getSoda(), item); 
		// there should not be any change
		assertTrue(!change.isEmpty()); 
		// comparing change
		assertEquals(50 - Item.getSoda().getPrice(), getTotal(change));
	}

	@Test
	public void testRefund() {
		BasicVendingMachine vm = new BasicVendingMachine();
		long price = vm.getItemPrice(Item.getPepsi(), 1);
		assertEquals(Item.getPepsi().getPrice(), price);
		vm.insertCoin(Coin.TEN);
		vm.insertCoin(Coin.FIVE);
		vm.insertCoin(Coin.ONE);
		assertEquals(16, getTotal(vm.refund()));
	}

	@Test(expected = InSufficientChangeException.class)
	public void testNotSufficientChangeException() {
		BasicVendingMachine vm = new BasicVendingMachine();
		for (int i = 0; i < 5; i++) {
			vm.getItemPrice(Item.getSoda(), 1);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.collectItemAndChange(1);
			vm.getItemPrice(Item.getPepsi(), 1);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.insertCoin(Coin.TEN);
			vm.collectItemAndChange(1);
		}
	}

	@Test(expected = NotAvailableException.class)
	public void testReset() {
		IVendingMachine vmachine = new BasicVendingMachine();
		vmachine.reset();
		vmachine.getItemPrice(Item.getCoke(), 1);
	}

	
	private long getTotal(List<Coin> change) {
		long total = 0;
		for (Coin c : change) {
			total = total + c.getValue();
		}
		return total;
	}
}
