package com.example.restaurant.naver.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageItem;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalItem;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import com.example.restaurant.wishlist.dto.WishListDTO;
import com.example.restaurant.wishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.repository.WishListRepository;

@Service
public class WishLIstServiceImpl implements WishListService {

	@Autowired
	private NaverClient naverClient;
	
	@Autowired
	private WishListRepository wishListRepository;
	
	@Override
	public WishListDTO search(String query) {
		
		//지역 검색 요청
		SearchLocalReq req = new SearchLocalReq();
		req.setQuery(query);
		
		SearchLocalRes res = naverClient.searchLocal(req);
		
		if(res.getTotal() > 0) {
			
			//지역 검색 중에서 첫번째 가져오기
			SearchLocalItem localItem= res.getItems().get(0);
			
			// 해당 가게 사진 검색하기 위해 제목 추출
			String imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
			
			// image 검색 요청
			SearchImageReq imageReq = new SearchImageReq();
			imageReq.setQuery(imageQuery);
			
			//이미지 검색 결과 받기
			SearchImageRes imageRes=naverClient.searchImage(imageReq);
			
			if(imageRes.getTotal() >0) {
				
				// 이미지 정보 중에서 첫번째 가져오기
				SearchImageItem imageItem = imageRes.getItems().get(0);
				
				
				//받은 정보들을 원하는 데이터만 추출해서 WishListDTO 담기
				WishListDTO dto = new WishListDTO();
				dto.setTitle(localItem.getTitle());
				dto.setCategory(localItem.getCategory());
				dto.setAddress(localItem.getAddress());
				dto.setRoadAddress(localItem.getRoadAddress());
				dto.setHomePageLink(localItem.getLink());
				dto.setImageLink(imageItem.getLink());
				
				System.out.println("dto "+dto);
				return dto;
			}
		}
		
		return new WishListDTO();
		
		
	}
	// 데이터 추가
	@Override
	public WishListDTO add(WishListDTO wishListDTO) {
		WishListEntity entity = dtoToEntity(wishListDTO);
		WishListEntity saveEntity = wishListRepository.save(entity);
		return entityToDto(saveEntity);
	}
	private WishListEntity dtoToEntity(WishListDTO wishListDTO) {
		//dto => entity 객체로
		WishListEntity entity = new WishListEntity();
		entity.setTitle(wishListDTO.getTitle());
		entity.setIdx(wishListDTO.getIdx());
		entity.setCategory(wishListDTO.getCategory());
		entity.setAddress(wishListDTO.getAddress());
		entity.setRoadAddress(wishListDTO.getRoadAddress());
		entity.setHomePageLink(wishListDTO.getHomePageLink());
		entity.setImage(wishListDTO.getImageLink());
		entity.setVisit(wishListDTO.isVisit());
		entity.setVisitCount(wishListDTO.getVisitCount());
		entity.setLastVisitDate(wishListDTO.getLastVisitDate());
		return entity;
	}
	private WishListDTO entityToDto(WishListEntity entity) {
		// entity =>> dto 객체로
		WishListDTO dto = new WishListDTO();
		dto.setTitle(entity.getTitle());
		dto.setIdx(entity.getIdx());
		dto.setCategory(entity.getCategory());
		dto.setAddress(entity.getAddress());
		dto.setRoadAddress(entity.getRoadAddress());
		dto.setHomePageLink(entity.getHomePageLink());
		dto.setImageLink(entity.getImage());
		dto.setVisit(entity.isVisit());
		dto.setVisitCount(entity.getVisitCount());
		dto.setLastVisitDate(entity.getLastVisitDate());
		return dto;
	}
	@Override
	public List<WishListDTO> all() {
		return wishListRepository.findAll().stream().map
				   (wish->entityToDto(wish))
				   .collect(Collectors.toList());
	}
	

}













