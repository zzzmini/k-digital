package com.my.jpaTest.repository;

import com.my.jpaTest.constant.Gender;
import com.my.jpaTest.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // name 컬럼으로 검색
    List<Users> findByName(String name);

    // 상위 3개의 같은 색상 정보 레코드 가져오기
    //SELECT top 3 * from users where like_color='Blue'
    List<Users> findTop3ByLikeColor(String color);

    // Female 이고 Pink 인 자료를 모두 찾아 봅니다.
    List<Users> findByGenderAndLikeColor(Gender gender,
                                         String color);

    // 범위로 검색하기(날짜/시간 Before, After)
    List<Users> findByCreatedAtAfter(LocalDateTime searchDate);
    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime searchDate);

    // between 으로 검색
    List<Users> findByIdBetween(Long start, Long end);

    // Null or IsNotNull
    List<Users> findByUpdatedAtIsNull();

    // In 구문
    List<Users> findByLikeColorIn(List<String> colors);

    // 문자열 관련 Query Method
    // StartingWith, EndingWith, Contains, Like
    List<Users> findByNameStartingWith(String name);

    List<Users> findByNameEndingWith(String name);

    List<Users> findByNameContains(String name);

    List<Users> findByNameLike(String name);

    // 정렬하기(OrderByAsc, OrderByDesc)
    // 1~10 아이디 검색해서 내림차순
    // findAll 찾아서 가공
//    List<Users> findTop10OrderByIdDesc();

    List<Users> findByIdBetweenOrderByIdDesc(Long start, Long end);

    // Orange 색상 중에 Gender 오름차순, CreateAt에 내림 처리 후
    // 상위 10개 검색
    List<Users> findTop10ByLikeColorOrderByGenderAscCreatedAtDesc(String color);

    // Pink 검색 Gender 내림, name 내림
    List<Users> findByLikeColor(String color, Sort sort);

    // Orange 색상을 찾아서 페이징 처리
    Page<Users> findByLikeColor(String color, Pageable pageable);

    //1번. 여성 중 w, m을 포함하는 자료
    List<Users> findByGenderAndNameLikeOrGenderAndNameLike(
            Gender gender1, String name1, Gender gender2, String name2
    );

    // 2번. 이메일에 net을 포함
    List<Users> findByEmailLike(String email);

    // 3번. 가장 최근 한달이내 업데이트 첫자 J
    // 2024-09-05 0:0:0 생성 .....
    List<Users> findByUpdatedAtGreaterThanEqualAndNameLike(
            LocalDateTime date, String name
    );

    // 4번. 가장 최근 자료 10건, id, name, gender, createdAt
    List<Users> findTop10ByOrderByCreatedAtDesc();

    // 5번. Red , 남성 이메일의 계정만
    List<Users> findByLikeColorAndGender(String color, Gender gender);

    // 6번. 갱신일 < 생성일
    // 7번. 이메일에 edu 여성 가장 최근
    List<Users> findByEmailLikeAndGenderOrderByCreatedAtDesc(
            String email, Gender gender
    );

    // 8번. 색상 오름차순, 같은 색상 데이터는 이름의 내림차순
    // 10번. 남성 자료 id 내림, 페이지당 3건, 2페이지
    Page<Users> findByGenderOrderByIdDesc(Gender gender
            , Pageable pageable);

    // 11번. 지난달 모든 자료
    List<Users> findByCreatedAtBetween(
            LocalDateTime start, LocalDateTime end
    );
}
