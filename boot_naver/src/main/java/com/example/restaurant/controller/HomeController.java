package com.example.restaurant.controller;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String main() {
		log.info("home 컨트롤러");
		return "main";
	}
	
	@GetMapping("/api/server/naver")
	public String naver() {
		log.info("네이버 검색 요청");
		
		URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
									  .path("/v1/search/local.json")
									  .queryParam("query", "갈비집")
									  .queryParam("display", "1")
									  .queryParam("start", "1")
									  .queryParam("sort", "random")
									  .encode()
									  .build()
									  .toUri();
									  
		log.info("URI : "+uri);

		
		RequestEntity<Void> req = RequestEntity.get(uri)
											   .header("X-Naver-Client-Id", "l6L4jvXbDCO1Kl5O1w4w")
											   .header("X-Naver-Client-Secret", "msZ2kg4KL6")
											   .build();
		
		ResponseEntity<String> result = new RestTemplate().exchange(req, String.class);
		
		return result.getBody();
	}
}
