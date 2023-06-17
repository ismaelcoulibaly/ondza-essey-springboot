package com.ondza.essey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OndzaEsseyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OndzaEsseyBackendApplication.class, args);
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.ondza.essey.controllers"))
//                .build();
//    }

}
