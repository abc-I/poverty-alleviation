package com.poverty;

import com.poverty.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.UUID;

@SpringBootTest
class PovertyApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("id：" + UUID.randomUUID().toString().replace("-", ""));

        Random random = new Random(System.currentTimeMillis());
        int account = random.nextInt();
        System.out.println("account：" + account);

        System.out.println(MD5Util.parse("user", "user", 10));

    }

}
