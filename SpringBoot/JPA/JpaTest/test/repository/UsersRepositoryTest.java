package com.my.jpaTest.repository;

import com.my.jpaTest.constant.Gender;
import com.my.jpaTest.entity.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
class UsersRepositoryTest {
    @Autowired
    UsersRepository usersRepository;

    @Test
    void test() {
        System.out.println("========= TEST =======");
    }

    @Test
    void findByName() {
        List<Users> lists = usersRepository.findByName("Calvin");
        lists.forEach(x -> System.out.println(x));
    }

    @Test
    void findTop3ByLikeColor() {
        usersRepository.findTop3ByLikeColor("Blue")
                .forEach(x -> System.out.println(x));

    }

    @Test
    void findByGenderAndLikeColor() {
        usersRepository.findByGenderAndLikeColor(
                Gender.Female, "Pink"
        ).forEach(System.out::println);
    }

    @Test
    void findByCreatedAtAfter() {
        usersRepository.findByCreatedAtAfter(
                LocalDateTime.now().minusDays(7L)
        ).forEach(x -> System.out.println(x));
    }

    @Test
    void findByCreatedAtGreaterThanEqual() {
        usersRepository.findByCreatedAtGreaterThanEqual(
                LocalDateTime.now().minusDays(1L)
        ).forEach(x -> System.out.println(x));
    }

    @Test
    void findByIdBetween() {
        usersRepository.findByIdBetween(1L, 5L)
                .forEach(x -> System.out.println(x));
    }

    @Test
    void findByUpdatedAtIsNull() {
        Long count =
                usersRepository.findByUpdatedAtIsNull().stream().count();
        System.out.println("IsNull Count = " + count);
    }

    @Test
    void findByLikeColorIn() {
        List<String> colors =
                Lists.newArrayList("Red", "Orange");
        usersRepository.findByLikeColorIn(colors)
                .forEach(x -> System.out.println(x));
    }

    @Test
    void findByNameStartingWith() {
        usersRepository.findByNameStartingWith("C")
                .forEach(x -> System.out.println(x));
    }

    @Test
    void findByNameEndingWith() {
        usersRepository.findByNameEndingWith("n")
                .forEach(x -> System.out.println(x));
    }

    @Test
    void findByNameContains() {
        usersRepository.findByNameContains("vin")
                .forEach(x -> System.out.println(x));
    }

    @Test
    void findByNameLike() {
        usersRepository.findByNameLike("%vin%")
                .forEach(x -> System.out.println(x));
    }

    @Test
    void findByIdBetweenOrderByDesc() {
        usersRepository.findByIdBetweenOrderByIdDesc(1L, 10L)
                .forEach(x -> System.out.println(x));
    }

//    @Test
//    void findTop10OrderByIdDesc() {
//        usersRepository.findTop10OrderByIdDesc()
//                .forEach(x -> System.out.println(x));
//    }

    @Test
    void findTop10ByLikeColorOrderByGenderAscCreatedAtDesc() {
        usersRepository
                .findTop10ByLikeColorOrderByGenderAscCreatedAtDesc("Pink")
                .forEach(x -> System.out.println(x));
    }

    @Test
        // 함수 추출 : Ctrl + Alt + M
        // refactor -> Extract Method
    void findByLikeColor() {
        usersRepository.findByLikeColor("Pink", getSort())
                .forEach(x -> System.out.println(x));
    }

    private Sort getSort() {
        return Sort.by(Sort.Order.desc("gender")
                , Sort.Order.desc("name"));
    }

    @Test
    @DisplayName("Paging Test")
    void pagingTest() {
        System.out.println("페이지 : 0, 페이지당 리스트 수 : 5");
        usersRepository.findAll(
                        PageRequest.of(0, 5,
                                Sort.by(Sort.Order.desc("name"))))
                .getContent()
                .forEach(x -> System.out.println(x));

        System.out.println("페이지 : 2, 페이지당 리스트 수 : 7");
        usersRepository.findAll(
                        PageRequest.of(1, 7,
                                Sort.by(Sort.Order.desc("id"))))
                .getContent()
                .forEach(x -> System.out.println(x));
    }

    @Test
    @DisplayName("findByColor 페이징 처리")
    void findByColorAndPaging() {
//        Sort sort = Sort.by(Sort.Order.desc("id"));
        Sort sort = Sort.by("id").descending();
        Pageable pageable =
                PageRequest.of(1, 7, sort);
        Page<Users> result = usersRepository
                .findByLikeColor("Orange", pageable);
        result.getContent().forEach(x -> System.out.println(x));

        // 총 페이지 수
        System.out.println("Total Pages : " + result.getTotalPages());

        // 전체 데이터 수
        System.out.println("Total Counts : " + result.getTotalElements());
        // 현재 페이지 번호
        System.out.println("Current Page Number : " +
                result.getNumber());
        // 페이지 당 데이터 개수
        System.out.println("Page Size : " + result.getSize());
        // 다음 페이지 존재 여부
        System.out.println("Has Next Page? " + result.hasNext());
        // 내 앞 페이지 확인
        System.out.println("Has Previous Page? " + result.hasPrevious());
        // 마지막 페이지 인지 확인
        System.out.println("Has Last Page? " + result.isLast());
    }

    @Test
    @DisplayName("1번")
    void findByGenderAndNameLikeOrGenderAndNameLike() {
        usersRepository
                .findByGenderAndNameLikeOrGenderAndNameLike(
                        Gender.Female, "%w%",
                        Gender.Female, "%m%"
                ).forEach(x -> System.out.println(x));
    }

    @Test
    @DisplayName("2번")
    void findByEmailLike() {
        long count = usersRepository.findByEmailLike("%net")
                .stream().count();
        System.out.println("net으로 끝나는 개수 : " + count);
    }

    @Test
    @DisplayName("3번")
    void findByUpdatedAtGreaterThanEqualAndNameLike() {
        LocalDate baseDate = LocalDate.now()
                .minusMonths(1L)
                .plusDays(1L);
        // 시작일 설정
        LocalDateTime date = baseDate.atTime(0, 0, 0);
        System.out.println("baseDate : " + date);
        usersRepository.findByUpdatedAtGreaterThanEqualAndNameLike(
                date, "J%"
        ).forEach(x -> System.out.println(x));
    }

    @Test
    // 4번. 가장 최근 자료 10건, id, name, gender, createdAt
    @DisplayName("4번")
    void findTop10ByOrderByCreatedAtDesc() {
        List<Users> lists = usersRepository
                .findTop10ByOrderByCreatedAtDesc();
        for (Users list : lists) {
            System.out.println("ID = " + list.getId() +
                    ", Name = " + list.getName() +
                    ", Gender = " + list.getGender() +
                    ", CreatedAt = " + list.getCreatedAt()
            );
        }
    }

    @Test
    @DisplayName("5번")
    void findByLikeColorAndGender() {
        List<Users> list = usersRepository.findByLikeColorAndGender(
                "Red", Gender.Male
        );
        for (Users user : list) {
            String email = user.getEmail();
            String account = email.substring(0, email.indexOf("@"));
            System.out.println("email : " + email + ", account : " + account);
        }
    }

    @Test
    @DisplayName("6번")
    void beforeUpdatedDate() {
        List<Users> list = usersRepository.findAll();
        for (Users user : list) {
            if (user.getUpdatedAt().isBefore(user.getCreatedAt())) {
                System.out.println(user);
            }
        }
    }

    @Test
    @DisplayName("7번")
    void findByEmailLikeAndGenderOrderByCreatedAtDesc() {
        usersRepository.findByEmailLikeAndGenderOrderByCreatedAtDesc(
                "%edu", Gender.Female
        ).forEach(x -> System.out.println(x));
    }

    @Test
    @DisplayName("8번")
    void likeColorOrderBy() {
        usersRepository.findAll(
                Sort.by(
                        Sort.Order.asc("likeColor"),
                        Sort.Order.desc("name")
                )
        ).forEach(x -> System.out.println(x));
    }
    // 전체 자료 중 최근 입력자료 순으로 정렬, 페이징, 한페이지당 10건
    // 그중 1번째 페이지 출력
    @Test
    @DisplayName("9번")
    void no_9() {
        usersRepository.findAll(
                PageRequest.of(0, 10,
                        Sort.by(Sort.Order.desc("createdAt")))
        ).getContent()
                .forEach(x-> System.out.println(x));
    }

    @Test
    @DisplayName("10번")
    void findByGenderOrderByIdDesc() {
        Pageable pageable = PageRequest.of(1, 3);
        Page<Users> list = usersRepository
                .findByGenderOrderByIdDesc(Gender.Male, pageable);
        list.getContent()
                .forEach(x -> System.out.println(x));
    }

    @Test
    @DisplayName("11번")
    void findByCreatedAtBetween() {
        // 기준일
        LocalDate baseDate = LocalDate
                .now()
                .minusMonths(1L);
        // 시작일 만들기
        LocalDateTime startDate =
                baseDate.withDayOfMonth(1)
                        .atTime(0, 0, 0);
        System.out.println("startDate = " + startDate);
        // 지난달의 마지막 날 만들기
        LocalDateTime endDate =
                baseDate.withDayOfMonth(baseDate.lengthOfMonth())
                        .atTime(23, 59, 59);
        System.out.println("endDate = " + endDate);
        usersRepository
                .findByCreatedAtBetween(startDate, endDate)
                .forEach(x -> System.out.println(x));
    }
}