package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchDTO {
	private String criteria;
	private String keyword;
}
