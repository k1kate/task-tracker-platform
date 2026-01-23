package com.ekate.backend.configuration;

import com.ekate.backend.repository.impl.AdminRepositoryImpl;
import com.ekate.backend.service.AdminService;
import com.ekate.backend.service.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AdminServiceConfiguration {
    @Bean
    public DBService DBService(){
        return new DBService();
    }

    @Bean
    public AdminRepositoryImpl adminRepository(){
        return new AdminRepositoryImpl();
    }

    @Bean
    public AdminService AdminService(DBService dbService,AdminRepositoryImpl adminRepository){
        return new AdminService(dbService,adminRepository);
    }
}

