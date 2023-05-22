package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	
	public int page; //페이지 번호
	public int amount; //한페이지당 몇개의 게시물을 보여줄 것인지
	
	public String type; //검색 조건
	public String keyword; //검색어
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}

	
}
