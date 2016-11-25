package com.example.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.domain.FoodPrice;
import com.example.service.FoodPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@RestController
public class TestControllerAjax {
	
	@Autowired
	FoodPriceService foodService;
	
	@RequestMapping(value = "/searchByNameAjax")
	String searchByName2(@RequestParam String searchKey, Model model) {
		List<FoodPrice> foodList = foodService.findByName(searchKey);

		return "Ajax処理："+searchKey;
	}

}
