package com.dungeonai.DungeonAi.service;

import com.dungeonai.DungeonAi.entity.ProfileImage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CharacterService {

    public String createCharacter() throws IOException {
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<ProfileImage> response = restTemplate.getForEntity("INSERT BACKEND LINK", ProfileImage.class);
//
//        ProfileImage image = response.getBody();
//        return image.getImages()[0];
        return "";
    }
}
