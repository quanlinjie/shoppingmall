package com.study.shoppingmaill.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.shoppingmaill.auth.PrincipalDetails;
import com.study.shoppingmaill.domain.History;
import com.study.shoppingmaill.domain.User;
import com.study.shoppingmaill.service.CartService;
import com.study.shoppingmaill.service.UserPageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SaleHistoryController {

    private final UserPageService userPageService;
    private final CartService cartService;

    // 판매내역 페이지
    @GetMapping("/seller/{sellerId}/history/{historyId}")
    public String salePageView(@PathVariable("sellerId") Integer sellerId, @PathVariable("historyId") Integer historyId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if(principalDetails.getUser().getId() != sellerId) {
            return "redirect:/main";
        }

        History history = cartService.getHistory(historyId);
        User user = history.getUser(); //
        User seller = history.getSeller();

        model.addAttribute("user", user);
        model.addAttribute("seller", seller);
        model.addAttribute("history", history);

        System.out.println(history);

        return "/seller/salePage";
    }
}
