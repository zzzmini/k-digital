package com.my.security_test.service;

import com.my.security_test.dto.CustomUserDetails;
import com.my.security_test.dto.UserRole;
import com.my.security_test.entity.UserEntity;
import com.my.security_test.oauth2.GoogleUserInfo;
import com.my.security_test.oauth2.KakaoUserInfo;
import com.my.security_test.oauth2.NaverUserInfo;
import com.my.security_test.oauth2.OAuth2UserInfo;
import com.my.security_test.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class Oauth2UserService extends DefaultOAuth2UserService {
    @Autowired
    UserEntityRepository entityRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration : "
                + userRequest.getClientRegistration());
        System.out.println("getAccessToken : " +
                userRequest.getAccessToken().getTokenValue());
        OAuth2User oAuth2User = super.loadUser(userRequest);
        // google의 회원 프로필 조회
        return processOAuth2User(userRequest, oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest,
                                         OAuth2User oAuth2User) {
        // Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
        OAuth2UserInfo oAuth2UserInfo = null;
        switch (userRequest.getClientRegistration().getRegistrationId()) {
            case "google" :
                System.out.println("구글 로그인 요청");
                oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
                break;
            case "naver":
                System.out.println("네이버 로그인 요청");
                Map<String, Object> response = (Map<String, Object>)
                        oAuth2User.getAttributes().get("response");
                oAuth2UserInfo = new NaverUserInfo(response);
                break;
            case "kakao":
                System.out.println("카카오 로그인 요청");
                oAuth2UserInfo = new
                        KakaoUserInfo((Map)oAuth2User.getAttributes());
                break;
            default:
                System.out.println("우리는 구글과 페이스북, 카카오만 지원해요");
        }

        Optional<UserEntity> userOptional =
                entityRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(),
                        oAuth2UserInfo.getProviderId());
        UserEntity user;
        if (userOptional.isPresent()) {
            user = userOptional.get();// user가 존재하면 update 해주기
            user.setEmail(oAuth2UserInfo.getEmail());
            entityRepository.save(user);
        } else {
            // user의 패스워드 해석불가하기 때문에 OAuth 유저는 일반적인로그인을 할 수 없음.
            user = UserEntity.builder()
                    .username(oAuth2UserInfo.getProvider() + "_" +
                            oAuth2UserInfo.getProviderId())
                    .email(oAuth2UserInfo.getEmail())
                    .role(UserRole.ROLE_USER)
                    .password(String.valueOf(UUID.randomUUID()))
                    .provider(oAuth2UserInfo.getProvider())
                    .providerId(oAuth2UserInfo.getProviderId())
                    .build();
            entityRepository.save(user);
        }
        return new CustomUserDetails(user, oAuth2User.getAttributes());
    }
}
