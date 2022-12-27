package com.study.shoppingmaill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.shoppingmaill.domain.Cart_item;

@Repository
public interface Cart_itemRepository extends JpaRepository<Cart_item, Integer> {
    List<Cart_item> findCart_itemByItemId(int id);
}
