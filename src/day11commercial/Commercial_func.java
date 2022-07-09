package day11commercial;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Commercial_func implements Commercial_interface{
	
	/*Initialization part
	 * 
	 */
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	@SuppressWarnings("rawtypes")
	public static final ArrayList history = new ArrayList();
	public String stock_holder_name;
	public String stock_name;
	public int no_of_stock;
	public double stock_price;
	/*
	 * Empty contructor for creating seperate object.
	 */
	public Commercial_func() {
	}
	/*
	 * Constructor for storing user information
	 */
	public Commercial_func(String name, String sname, int nos, double sprice) {
		this.stock_holder_name = name;
		this.stock_name = sname;
		this.no_of_stock = nos;
		this.stock_price = sprice;
	}
	
	/*
	 * Method to implement Buying of stocks
	 */
	@SuppressWarnings("unchecked")
	public void buy_stocks() {
		boolean t = true;
		while (t) {
			Commercial_func temp = (Commercial_func) Commercial_main.stock.get(0);
			System.out.println("Enter the name of the person from whom you want to buy stocks");
			String ch = Commercial_main.sc.next();
			for (int i = 1; i < Commercial_main.stock.size(); i++) {
				Commercial_func temp1 = (Commercial_func) Commercial_main.stock.get(i);
				if (ch.equals(temp1.stock_holder_name)) {
					System.out
							.println(temp1.stock_holder_name + " has " + temp1.no_of_stock + " in " + temp1.stock_name);
					System.out.println("Enter how many stocks you want to buy from him");
					int n = Commercial_main.sc.nextInt();
					temp1.no_of_stock -= n;
					temp.no_of_stock += n;
					Date date = new Date();
					String str = formatter.format(date);
					@SuppressWarnings("rawtypes")
					ArrayList t1 = new ArrayList();
					t1.add(temp.stock_holder_name);
					t1.add(temp1.stock_holder_name);
					t1.add("bought");
					t1.add(str);
					history.add(t1);
					break;
				}
				if (i == Commercial_main.stock.size() - 1) {
					System.out.println("No such user found");
				}
			}
			System.out.println("Do you want to buy more shares? Y/N");
			char ch1 = Commercial_main.sc.next().charAt(0);
			if (ch1 == 'N') {
				t = false;
				display();
			}
		}
	}
	
	/*
	 * Method to implement selling of stocks
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sell_stocks() {
		boolean t = true;
		while (t) {
			Commercial_func temp = (Commercial_func) Commercial_main.stock.get(0);
			System.out.println("Enter the name of the person to whom you want to sell stocks");
			String ch = Commercial_main.sc.next();
			for (int i = 1; i < Commercial_main.stock.size(); i++) {
				Commercial_func temp1 = (Commercial_func) Commercial_main.stock.get(i);
				if (ch.equals(temp1.stock_holder_name)) {
					System.out
							.println(temp1.stock_holder_name + " has " + temp1.no_of_stock + " in " + temp1.stock_name);
					System.out.println("Enter how many stocks you want to sell");
					int n = Commercial_main.sc.nextInt();
					temp1.no_of_stock += n;
					temp.no_of_stock -= n;
					Date date = new Date();
					String str = formatter.format(date);
					ArrayList t1 = new ArrayList();
					t1.add(temp.stock_holder_name);
					t1.add(temp1.stock_holder_name);
					t1.add(str);
					t1.add("selled");
					history.add(t1);
					break;
				}
				if (i == Commercial_main.stock.size()) {
					System.out.println("No such user found");
				}
			}
			System.out.println("Do you want to sell more shares? Y/N");
			char ch1 = Commercial_main.sc.next().charAt(0);
			if (ch1 == 'N') {
				t = false;
				display();
			}
		}
	}
	
	/*
	 * Method to display the current stocks of the persons and history of the transactions made.
	 */
	@SuppressWarnings("rawtypes")
	public void display() {
		for (int i = 1; i < Commercial_main.stock.size(); i++) {
			Commercial_func temp1 = (Commercial_func) Commercial_main.stock.get(i);
			System.out.println(temp1.stock_holder_name + " has " + temp1.no_of_stock + " in " + temp1.stock_name);
		}
		System.out.println("");
		System.out.println("---------------------------------------------------");

		if (history.size() != 0) {
			for (int i = 0; i < history.size(); i++) {
				if ((String) ((ArrayList) history.get(i)).get(2) == "bought") {
					String fname = (String) ((ArrayList) history.get(i)).get(0);
					String sname = (String) ((ArrayList) history.get(i)).get(1);
					String d = (String) ((ArrayList) history.get(i)).get(3);
					System.out.println(fname + " has bought his stock from " + sname + " at " + d);
				} else if ((String) ((ArrayList) history.get(i)).get(3) == "selled") {
					String fname = (String) ((ArrayList) history.get(i)).get(0);
					String sname = (String) ((ArrayList) history.get(i)).get(1);
					String d = (String) ((ArrayList) history.get(i)).get(2);
					System.out.println(fname + " has selled his stock to " + sname + " at " + d);
				}
			}

		}
		System.out.println("Do yo wish to buy more stocks? Y/N");
		char ch2 = Commercial_main.sc.next().charAt(0);
		if (ch2 == 'Y') {
			buy_stocks();
		}

	}
}
