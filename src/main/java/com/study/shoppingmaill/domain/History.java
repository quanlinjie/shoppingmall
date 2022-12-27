package com.study.shoppingmaill.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity // DB에 테이블 자동 생성
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user; // 구매자 유저 정보

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="seller_id")
    private User seller; // 판매자 정보


    private String itemName; // 구매한 아이템 명
    private int itemPrice; // 구매한 아이템 가격
    private int itemCount; // 구매한 아이템 수량

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 구매 날짜

    @PrePersist // DB에 INSERT 되기 직전에 실행. 즉 DB에 값을 넣으면 자동으로 실행됨
    public void createDate() {
        this.createDate = LocalDate.now();
    }

}