package com.study.shoppingmaill.service;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.shoppingmaill.domain.User;
import com.study.shoppingmaill.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserPageService {

    private final UserRepository userRepository;

    public User findUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public void userPageModify(User user, MultipartFile file) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);


        User before = userRepository.findById(user.getId()); // 기존 유저
        before.setFilename(fileName);
        before.setFilepath("/files/" + fileName);
        before.setEmail(user.getEmail());
        before.setAddress(user.getAddress());
        before.setPhone(user.getPhone());
        userRepository.save(before);

    }

    public void chargeMoney(User user, int money) {
        user.setMoney(user.getMoney() + money);
        userRepository.save(user);
    }
}
