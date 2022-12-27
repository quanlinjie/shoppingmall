package com.study.shoppingmaill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.shoppingmaill.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById(int id);

    List<Item> findItemsByUserIdOrderByCountDesc(int id);

}
