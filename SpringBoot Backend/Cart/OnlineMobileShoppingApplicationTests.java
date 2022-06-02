package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartDTO;
import com.example.demo.entities.Customer;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.CartServiceImpl;
import com.example.demo.service.ICartService;

@SpringBootTest
class OnlineMobileShoppingApplicationTests {
	@Autowired
	private ICartService cartservice;
//	@Test
//	void contextLoads() {
//	}

	@Test
	public void addMobileToCartTest() {
		CartDTO cartDTO = new CartDTO("3463594774646879947888393", "3429392027");
		Cart newCart = null;
		try {
			newCart = this.cartservice.addMobileToCart(cartDTO);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MobileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(newCart);
	}

	@Test
	public void customerExisted() {
		CartDTO cartDTO = new CartDTO("3463594774646879947888312", "3429392021");
		Cart newCart = null;
		assertThrows(CustomerException.class, () -> this.cartservice.addMobileToCart(cartDTO));
	}

	@Test
	public void mobileIdExisted() {
		CartDTO cartDTO = new CartDTO("3463594774646879947888312", "3429392021");
		Cart newCart = null;
		assertThrows(MobileException.class, () -> this.cartservice.addMobileToCart(cartDTO));
	}
}
