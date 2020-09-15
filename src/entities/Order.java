package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import entities.enums.OrderStatus;

public class Order {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {}
	
	public Order(OrderStatus status, Client client) {
		this.moment = new Date();		
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		Double sum = 0.00;
		for(int i=0; i<items.size(); i++) {
			sum += items.get(i).subTotal();
		}
		return sum;
	}
	
	public String toString() {
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\nOrder moment:");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status:");
		sb.append(status + "\n");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem i : items) {
			sb.append(i + "\n");
		}
		sb.append("Total price: ");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
