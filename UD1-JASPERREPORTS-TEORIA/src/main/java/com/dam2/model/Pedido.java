package com.dam2.model;

import java.util.List;

public class Pedido {

	private String id;
	private List<Item> items;
	public Pedido() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	} 
	
	
}
