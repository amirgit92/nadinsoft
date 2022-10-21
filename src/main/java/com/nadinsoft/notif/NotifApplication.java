package com.nadinsoft.notif;

import com.nadinsoft.notif.alarm.AlarmDao;
import com.nadinsoft.notif.alarm.AlarmEntity;
import com.nadinsoft.notif.alarm.AlarmType;
import com.nadinsoft.notif.alarm.dto.AlarmDTO;
import com.nadinsoft.notif.alarm.dto.CreateAlarmDTO;
import com.nadinsoft.notif.customer.CustomerDao;
import com.nadinsoft.notif.customer.CustoomerEntity;
import com.nadinsoft.notif.customer.MembeerOf;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class NotifApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotifApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    CommandLineRunner run(AlarmDao alarmDao, CustomerDao customerDao) {
        return args -> {
            CustoomerEntity customer1 = new CustoomerEntity("amir", MembeerOf.ADMINISTRATORS);
            CustoomerEntity customer2 = new CustoomerEntity("mahsa", MembeerOf.CUSTOMERS);
            customerDao.saveAll(Arrays.asList(customer1,customer2));


            AlarmEntity alarm1 =
                    new AlarmEntity(AlarmType.MESSAGE,"message_name","this a simple message");
            AlarmEntity alarm2 =
                    new AlarmEntity(AlarmType.SYSTEM,"system_name","this a simple system message");
            AlarmEntity alarm3 =
                    new AlarmEntity(AlarmType.MESSAGE,"message_name2","this another message");
            AlarmEntity alarm4 =
                    new AlarmEntity(AlarmType.ERROR,"errorname","this an error");
            alarmDao.saveAll(Arrays.asList(alarm1,alarm2,alarm3,alarm4));

            customer1.getAlaarmEntitySet().addAll(Arrays.asList(alarm1,alarm2,alarm3));
            customer2.getAlaarmEntitySet().addAll(Arrays.asList(alarm3,alarm4));
            customerDao.saveAll(Arrays.asList(customer1,customer2));
        };

    }

}
