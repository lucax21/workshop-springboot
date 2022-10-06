package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Category;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria", "maria@email.com", "9999999", "123445");
		User u2 = new User(null, "Mauro", "mauro@email.com", "9999992", "123446");
		
		
		Order o1 = new Order(null, Instant.parse("2016-06-23T19:54:04Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2016-06-23T19:55:04Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2016-08-23T19:54:04Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		userRepo.saveAll(Arrays.asList(u1,u2));
		orderRepo.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
