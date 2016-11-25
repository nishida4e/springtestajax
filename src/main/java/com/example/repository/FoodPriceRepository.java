package com.example.repository;

import com.example.domain.FoodPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodPriceRepository extends JpaRepository<FoodPrice, Integer> {

	@Query("SELECT a FROM FoodPrice a WHERE a.name LIKE %:name%")
	List<FoodPrice> findByNameContaining(@Param("name") String name);

	// http://docs.spring.io/spring-data/jpa/docs/current/reference/html/

}
