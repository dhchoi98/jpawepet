package com.wepet.jpawepet;


import com.wepet.jpawepet.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        User user = new User();
        user.setName("Test1");
        user.setEmail("test@naver.com");
        user.setBirthday(LocalDate.of(1999, 6, 17));
        user.setPhoneNumber("010-1234-5678");
        user.setPassword("testtest123");
        user.setGender(Gender.MALE);

        Long savedId = userRepository.save(user);
        User findUser = userRepository.findUserById(savedId);

        Assertions.assertThat(findUser.getId()).isEqualTo(savedId);
        Assertions.assertThat(findUser).isEqualTo(user);

    }
}