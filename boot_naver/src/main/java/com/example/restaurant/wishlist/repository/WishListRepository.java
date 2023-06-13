package com.example.restaurant.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant.wishlist.entity.WishListEntity;



@Repository
public interface WishListRepository extends JpaRepository<WishListEntity, Long>{

}
