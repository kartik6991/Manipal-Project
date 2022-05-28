package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CartDTO;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Mobile;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;
import com.example.demo.service.ICartService;


@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")

public class CartController {
	@Autowired
	private ICartService cartService;
	
	@PostMapping("cart")
	public Cart addToCart(@RequestBody CartDTO cartDTO) throws CustomerException,MobileException{
		return this.cartService.addMobileToCart(cartDTO);
	}
	
	@DeleteMapping("cart")
	public Cart deleteMobileItemsfromCart(@RequestBody CartDTO cartDTO) throws CustomerException,MobileException{
		return this.cartService.deleteMobileItemsfromCart(cartDTO);
	}
	
	@GetMapping("cart/{id}")
	public List<Mobile> displayCart(@PathVariable("id") String customerid) throws CustomerException{
		return this.cartService.displayCartByCustomerId(customerid);
	}
}
