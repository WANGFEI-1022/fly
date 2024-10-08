package com.wf.imaotai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.wf.imaotai", "com.wf.common" })
@MapperScan(basePackages = "com.wf.imaotai.mapper")
@EnableTransactionManagement
public class FlyIMaoTaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyIMaoTaiApplication.class, args);
    }

}
