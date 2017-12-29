package xmu.crms;
import org.mybatis.spring.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * XXX class
 * 
 * @author 吕柏翰
 * @date 2017/11/29
 */
@SpringBootApplication
@MapperScan(basePackages = "xmu.crms.mapper")
public class Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(Application.class, args);
    }

}

