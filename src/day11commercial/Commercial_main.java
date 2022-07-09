package day11commercial;

import java.util.ArrayList;
import java.util.Scanner;

public class Commercial_main {
	@SuppressWarnings("rawtypes")
	public static final ArrayList stock = new ArrayList();
	public static final Scanner sc = new Scanner(System.in);
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/*
		 *Using constructor to save user details 
		 */
		Commercial_func c = new Commercial_func();
		Commercial_func cf = new Commercial_func("Siva", "Infosys", 50, 2000);
		stock.add(cf);
		Commercial_func cf1 = new Commercial_func("Siva1", "wipro", 500, 2000);
		stock.add(cf1);
		Commercial_func cf2 = new Commercial_func("Siva2", "cognizant", 100, 2000);
		stock.add(cf2);
		Commercial_func cf3 = new Commercial_func("Siva3", "bridge", 200, 2000);
		stock.add(cf3);
		Commercial_func cf4 = new Commercial_func("Siva4", "google", 550, 2000);
		stock.add(cf4);
		
		/*
		 * Asking choice to the user
		 */
		System.out.println("1.Buy stocks\n2.Sell stocks");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			c.buy_stocks();
			break;

		case 2:
			c.sell_stocks();
			break;
		}
	}

}
