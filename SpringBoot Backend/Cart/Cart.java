package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Cart {
	private List<Mobile> mobiles = new ArrayList<Mobile>();
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(List<Mobile> mobiles) {
		super();
		this.mobiles = mobiles;
	}
	public List<Mobile> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<Mobile> mobiles) {
		this.mobiles = mobiles;
	}
}
