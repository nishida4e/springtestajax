package com.example.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.domain.FoodPrice;
import com.example.service.FoodPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

@RestController
public class TestControllerAjax {
	
	@Autowired
	FoodPriceService foodService;
	
	@RequestMapping(value = "/searchByNameAjax")
	String searchByName2(@RequestParam String searchKey, Model model) {
		//List<FoodPrice> foodList = foodService.findByName(searchKey);
		
		//現在のページ
		int currentPage = 3;
		//1ページあたりの表示件数
		int elementsOnPage = 2;
		Pageable pageable = new PageRequest((currentPage-1), elementsOnPage);
		Page<FoodPrice> page = foodService.findByName(searchKey, pageable);
		
		System.out.println("現在のページ："+(page.getNumber()+1));
		System.out.println("全ページ数："+page.getTotalPages());
		System.out.println("1ページあたりの表示件数："+page.getSize());
		System.out.println("全件数："+page.getTotalElements());
		
		List<FoodPrice> foodListPager = page.getContent();
		
		System.out.println(foodListPager.toString());
		
		return foodListPager.toString();
	}

}
