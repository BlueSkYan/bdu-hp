package xyz.blueskyan.bduhpuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Shelumiel Yan
 */
@SpringBootApplication
@MapperScan("xyz.blueskyan.bduhpuser.mapper")
public class BduHpUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BduHpUserApplication.class, args);
    }

}
