package com.poverty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/11 10:57
 */
@SpringBootApplication
@MapperScan(basePackages={"com.poverty.mapper"})
@EnableTransactionManagement
public class PovertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PovertyApplication.class, args);
    }

}
