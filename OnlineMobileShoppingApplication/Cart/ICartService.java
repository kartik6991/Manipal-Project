package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.CartDTO;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Mobile;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;

public interface ICartService {

	Cart addMobileToCart(CartDTO cartDTO) throws CustomerException, MobileException;

	Cart deleteMobileItemsfromCart(CartDTO cartDTO) throws CustomerException, MobileException;

	List<Mobile> displayCartByCustomerId(String customerid) throws CustomerException;
}
