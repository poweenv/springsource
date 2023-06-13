package com.spring.memo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.memo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	
	// findBy + file명
	// 상품 이름으로 검색
	 
	List<Item> findByItemNm(String itemNm);
	
	// 상품명 or 상품상세설명
	List<Item> findByItemNmOrItemDetail(String itemNm,String itemDetail);
	
	// 특정가격 이하인 상품 조회
	List<Item> findByPriceLessThan(int price);
	
	//특정 가격 이하인 상품 조회 후 내림차순 정렬
	List<Item> findByPriceLessThanOrderByPriceDesc(int price);
}
