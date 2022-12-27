package com.study.shoppingmaill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.shoppingmaill.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByUserId(int id);
}
