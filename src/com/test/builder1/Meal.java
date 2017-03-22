package com.test.builder1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rajeev Krishna Singh
 *
 * Class to prepare meal
 *
 */
public class Meal {
	private List<Item> items = new ArrayList<Item>();	

	   public void addItem(Item item){
	      items.add(item);
	   }

	   public BigDecimal getCost(){
		   BigDecimal cost = BigDecimal.ZERO;
	      
	      for (Item item : items) {
	         cost = cost.add(item.getPrice());
	      }		
	      return cost;
	   }

	   public void showItems(){
	   
	      for (Item item : items) {
	         System.out.print("Item : " + item.getName());
	         System.out.print(", Packing : " + item.getPacking().pack());
	         System.out.println(", Price : " + item.getPrice());
	      }		
	   }
}
