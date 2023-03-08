package classExample.coffeeshop;

import java.util.Arrays;

public class CoffeeShopMain {

	public static void main(String[] args) {
		CoffeeShop cs = new CoffeeShop();
		cs.initialize();
		
		while (true) {
			int selection = cs.menuPrompt();
			
			if (selection == CoffeeShop.PRINT_MENU) {
				cs.printMenuItems();
			} else if (selection == CoffeeShop.ORDER_ITEM){
				cs.orderItem();
			} else if (selection == CoffeeShop.VIEW_CART) {
				cs.viewCart();
			} else if (selection == CoffeeShop.EXIT) {
				System.out.println("Thank you! Please come again");
				System.exit(0);
			}
		}
	}
}
