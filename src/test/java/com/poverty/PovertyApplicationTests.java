package com.poverty;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PovertyApplicationTests {

    @Test
    void contextLoads() {
//        System.out.println("id：" + UUID.randomUUID().toString().replace("-", ""));

        long max = 9999999999999L;
        long min = 1L;
        System.out.println((long) (Math.random() * (max - min) + min));

//
//        System.out.println(MD5Util.parse("user", "user", 10));

    }
}