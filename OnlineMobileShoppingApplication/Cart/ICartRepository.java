package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Cart;

public interface ICartRepository extends MongoRepository<Cart, String> {
}
