package xyz.blueskyan.bduhpadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BduHpAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BduHpAdminApplication.class, args);
    }

}
