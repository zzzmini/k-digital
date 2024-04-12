package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Gender;
import com.example.thymeleafTest.vo.Language;
import com.example.thymeleafTest.vo.Mail;
import com.example.thymeleafTest.vo.UserDto;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class FormControlController {
    @ModelAttribute("mail")
    private Mail[] mail(){
        return Mail.values();
    }

    @ModelAttribute("gender")
    private Gender[] genders(){
        return Gender.values();
    }
    @GetMapping("/signup")
    public String signUpGet(Model model){
        model.addAttribute("dto", new UserDto());
        return "/signUpView";
    }

    @PostMapping("/signup")
    public String signUpPost(@ModelAttribute("dto")UserDto dto,
                             Model model){
        String resultGender = null;
        String resultPassword = null;
        String resultEmail = null;

        // 동의사항체크(세개의 필드가 늘 표시되어야 하므로 배열로 처리)
        // 뷰에서 선택한 리스트를 기반으로 동의/미동의를 배열에 저장
        String arrArgee[] = {"미동의", "미동의", "미동의"};
        for(int i=0; i < dto.getAgreeList().size(); i++){
            switch (dto.getAgreeList().get(i)) {
                case "list1" :
                    arrArgee[0] = "동의";
                    break;
                case "list2" :
                    arrArgee[1] = "동의";
                    break;
                case "list3" :
                    arrArgee[2] = "동의";
                    break;
            }
        }

        // 전달받은 이메일 두개를 합침.(계정@naver.com....)
        resultEmail = dto.getEmail1() + "@" +  dto.getEmail2();

        // 두개의 패스워드를 받아 동일성 여부를 확인해서 결과 생성
        if(dto.getPassword1().equals(dto.getPassword2())){
            resultPassword = "일치함";
        } else {
            resultPassword = "틀림";
        }

        // 성별값을 받아 문자열로 전환해 뷰로 전송
        switch (dto.getGender()){
            case "MALE":
                resultGender = "남자";
                break;
            case "FEMALE":
                resultGender= "여자";
                break;
            case "NONE":
                resultGender = "선택안함";
                break;
        }

        // 동의 사항 체크 결과를 확인할 배열 전달
        model.addAttribute("arrAgree", arrArgee);
        // 완성된 이메일 계정을 전달
        model.addAttribute("resultEmail", resultEmail);
        // 성별 표시할 값 전달
        model.addAttribute("resultGender", resultGender);
        // 패스워드 1차 2차 동일 확인 메시지 전달
        model.addAttribute("resultPassword", resultPassword);
        // 사용자가 입력해서 전달받은 dto 그대로 뷰로 전달
        model.addAttribute("dto", dto);

        //로그 찍어보기
        log.info("회원아이디 : " + dto.getId());
        log.info("비밀번호1 : " + dto.getPassword1());
        log.info("비밀번호2 : " + dto.getPassword2());
        log.info("성명 : " + dto.getName());
        log.info("생년월일 : " + dto.getBirth());
        log.info("성별 : " + dto.getGender());
        for(String list : dto.getAgreeList()){
            log.info("동의 : " + list);
        }
        log.info("E-Mail : " + dto.getEmail1());
        log.info("E-Mail : " + dto.getEmail2());
        log.info("휴대폰 : " + dto.getPhone());

        //모델에 담아서 아래쪽 폼으로 전달
        return "/formControlResultView";
    }

    // 이용약관을 뷰에 표시할 데이터 설정
    @ModelAttribute("agree")
    private Map<String, String> agree(){
        Map<String, String> map = new HashMap<>();
        map.put("list1", "이용약관 동의(필수)");
        map.put("list2", "개인정보 수집이용동의(필수)");
        map.put("list3", "개인정보 수집이용동의(선택)");
        return map;
    }
}
