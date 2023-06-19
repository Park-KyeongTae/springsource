package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.naver.service.WishListService;
import com.example.restaurant.wishlist.dto.WishListDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
public class ApiController {

	@Autowired
	private WishListService wishListService;
	
	@GetMapping("/search")
	public WishListDTO search(String query) {
		log.info("검색 요청" + query);
		return wishListService.search(query);
	}
	                                  
	@PostMapping("") // /api/restaurant
	public WishListDTO add(@RequestBody WishListDTO wishLIstDTO) {
		log.info("wish 추가"+ wishLIstDTO);
		return wishListService.add(wishLIstDTO);
	}               
	@GetMapping("/all")
	public List<WishListDTO> getList(){
		log.info("wish list 요청");
		return wishListService.all();
	}
}
