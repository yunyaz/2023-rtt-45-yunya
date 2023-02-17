package classExample.coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

	public static final int PRINT_MENU = 1;
	public static final int ORDER_ITEM = 2;
	public static final int VIEW_CART = 3;
	public static final int EXIT = 4;

	private List<MenuItem> menuItems = new ArrayList<>();
	private List<MenuItem> cart = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	public void initialize() {
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setQuantityInStock(20);

		menuItems.add(item1);

		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);
		item2.setQuantityInStock(35);

		menuItems.add(item2);

		MenuItem item3 = new MenuItem("Small Cookie", 3.99, 18);
		menuItems.add(item3);

		MenuItem item4 = new MenuItem("English Tea", 2.99, 14);
		menuItems.add(item4);

		menuItems.add(new MenuItem("Egg Sandwich", 14.99, 8));
		
		menuItems.sort(new Comparator<MenuItem>() {

			@Override
			public int compare(MenuItem o1, MenuItem o2) {
				Double price1 = o1.getPrice();
				Double price2 = o2.getPrice();
				
				// ascending order
				return price1.compareTo(price2);
				
//				// descending order
//				return price2.compareTo(price1);
				
			}
			
		});
		
//		menuItems.sort(new Comparator<MenuItem>() {
//
//			@Override
//			public int compare(MenuItem o1, MenuItem o2) {
//				String name1 = o1.getName();
//				String name2 = o2.getName();
//				
//				return name1.compareTo(name2);
//			}
//			
//		});
		
//		menuItems.sort((a, b) -> (int)a.getPrice() - (int)b.getPrice());
		
//		menuItems.sort((a, b) -> ((Double)a.getPrice()).compareTo((Double)b.getPrice()));
		
//		menuItems.sort((a, b) -> a.getName().compareTo(b.getName()));
		
		
	}

	public void printMenuItems() {
		System.out.println("Item Name\tPrice\tQuantity In Stock");
		System.out.println("---------\t-----\t-----------------");

		for (MenuItem item : menuItems) {
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()) 
				+ "\t" + item.getQuantityInStock());
		}

		System.out.println("---------\t-----\t-----------------\n");
	}

	public int menuPrompt() {

		System.out.println("Welcome to Yunya's Coffee Shop\n");
		System.out.println(PRINT_MENU + ") Print Menu");
		System.out.println(ORDER_ITEM + ") Order Item");
		System.out.println(VIEW_CART + ") View Cart");
		System.out.println(EXIT + ") Exit Coffee Shop");
		System.out.print("\nMake Selection : ");

		int selection = scanner.nextInt();
		scanner.nextLine();

		System.out.println(" ");

		return selection;
	}

	public void orderItem() {
		printMenuItems();

		System.out.print("Enter Item Name: ");
		String itemName = scanner.nextLine();

		MenuItem selectedItem = findMenuItemByName(itemName);
		
		if (selectedItem != null) {
			System.out.println("\n" + selectedItem.getName() + " added to your cart.\n");
			cart.add(selectedItem);
		} else {
			System.out.println("\n" + itemName + " is not a valid selection\n");
		}
	}

	private MenuItem findMenuItemByName(String itemName) {
		if (itemName == null) {
			return null;
		}

		itemName = itemName.trim();

		for (MenuItem menuItem : menuItems) {
			String name = menuItem.getName();
			if (name.equalsIgnoreCase(itemName)) {
				return menuItem;
			}
		}
		return null;
	}
	
	public void viewCart() {
		System.out.println(cart.size() + " items in your cart: \n");
		
		double totalPrice = 0.0;
		
		System.out.println("Item Name\tPrice");
		System.out.println("---------\t-----");
		
		for (MenuItem item : cart) {
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()));
			totalPrice = totalPrice + item.getPrice();
		}
		System.out.println("---------\t-----");
		System.out.println("Total Price\t" + formatPrice(totalPrice));
		System.out.println();
	}
	
	private String formatPrice(double price) {
		String pattern = "$###.00";
		DecimalFormat df = new DecimalFormat(pattern);
		String formattedPrice = df.format(price);
		
		return formattedPrice;
	}
}
