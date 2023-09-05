package org.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName HcyApplication
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/9/4 12:39
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan("org.example.mapper")
@Slf4j
public class HcyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HcyApplication.class,args);
        log.info("server started");
    }
}
