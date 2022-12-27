package com.study.shoppingmaill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.shoppingmaill.domain.History;
import com.study.shoppingmaill.domain.User;

public interface HistoryRepository extends JpaRepository<History, Integer> {
    List<History> findHistoriesByUser(User user);
    History findHistoryByUser(User user);

    List<History> findHistoryBySeller(User user); // seller

    History findHistoryById(int id);
}
