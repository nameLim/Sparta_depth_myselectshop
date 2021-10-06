package com.sparta_depth.fclass.validator;

import com.sparta_depth.fclass.dto.ProductRequestDto;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class ProductValidator {
    public static void validateProductInput(ProductRequestDto requestDto, Long userId) {
        // 입력값 Validation
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("회원 Id 가 유효하지 않습니다.");
        }

        if (requestDto.getTitle() == null || requestDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("저장할 수 있는 상품명이 없습니다.");
        }

        if (!URLValidator.isValidUrl(requestDto.getImage())) {
            throw new IllegalArgumentException("상품 이미지 URL 포맷이 맞지 않습니다.");
        }

        if (!URLValidator.isValidUrl(requestDto.getLink())) {
            throw new IllegalArgumentException("상품 최저가 페이지 URL 포맷이 맞지 않습니다.");
        }

        if (requestDto.getLprice() <= 0) {
            throw new IllegalArgumentException("상품 최저가가 0 이하입니다.");
        }
    }

//    private static boolean isValidUrl(String url)
//    {
//        try {
//            new URL(url).toURI();
//            return true;
//        }
//        catch (URISyntaxException exception) {
//            return false;
//        }
//        catch (MalformedURLException exception) {
//            return false;
//        }
//    }
}
