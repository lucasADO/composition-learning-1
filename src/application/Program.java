package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name:");
		String clientName = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birthday date (DD/MM/YYYY): ");
		Date birthday = sdf.parse(sc.next());
		Client client = new Client(clientName, email, birthday);
		
		System.out.println("Enter order data:");
		
		System.out.print("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next());		
		Order order = new Order(status, client);
		
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter product #" + i + " data:");
			System.out.print("Product name:");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price:");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity:");
			int productQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(productQuantity, product);
			order.addItem(item);			
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}

}
