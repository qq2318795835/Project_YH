package cn.datasupermacy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.datasupermacy.dao")
public class DcrepApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcrepApplication.class, args);
    }

}
