@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    // userRequest 는 code를 받아서 accessToken을 응답 받은 객체
    // 함수 종료 시 @AuthenticationPrincipal Annotation 생성
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws
            OAuth2AuthenticationException {
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

        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if
        (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            Map<String, Object> response = (Map<String, Object>)
                    oAuth2User.getAttributes().get("response");
            oAuth2UserInfo = new NaverUserInfo(response);
        } else if
        (userRequest.getClientRegistration().getRegistrationId().equals("kakao")){
            System.out.println("카카오 로그인 요청");
            oAuth2UserInfo = new
                    KakaoUserInfo((Map)oAuth2User.getAttributes());
        }
        else {
            System.out.println("우리는 구글과 페이스북, 카카오만 지원해요");
        }

        Optional<UserAccount> userOptional =

                userAccountRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(),
                        oAuth2UserInfo.getProviderId());

        UserAccount user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            // user가 존재하면 update 해주기
            user.setEmail(oAuth2UserInfo.getEmail());
            userAccountRepository.save(user);
        } else {
            // user의 패스워드 해석불가하기 때문에 OAuth 유저는 일반적인
            //로그인을 할 수 없음.
            user = UserAccount.builder()
                    .username(oAuth2UserInfo.getProvider() + "_" +
                            oAuth2UserInfo.getProviderId())
                    .email(oAuth2UserInfo.getEmail())
                    .userRole(UserRole.USER)
                    .userPassword(String.valueOf(UUID.randomUUID()))
                    .provider(oAuth2UserInfo.getProvider())
                    .providerId(oAuth2UserInfo.getProviderId())
                    .build();
            userAccountRepository.save(user);
        }

        return new PrincipalDetails(user, oAuth2User.getAttributes());
    }
}
