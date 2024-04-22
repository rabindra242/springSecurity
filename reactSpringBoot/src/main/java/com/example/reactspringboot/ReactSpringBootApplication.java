package com.example.reactspringboot;

import com.example.reactspringboot.domain.RequestContext;
import com.example.reactspringboot.entity.RoleEntity;
import com.example.reactspringboot.enumaration.Authority;
import com.example.reactspringboot.repo.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class ReactSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository){
        return args -> {
//            RequestContext.setUserId(0L);
//            var userRole=new RoleEntity();
//            userRole.setName(Authority.USER.name());
//            userRole.setAuthorities(Authority.USER);
//            roleRepository.save(userRole);
//
//            var adminRole=new RoleEntity();
//            adminRole.setName(Authority.ADMIN.name());
//            adminRole.setAuthorities(Authority.ADMIN);
//            roleRepository.save(adminRole);
//            RequestContext.start();




        };
    }

}
