package com.ekate.backend.configuration;

import com.ekate.backend.BackendApplication;
import com.ekate.backend.entity.DatabaseMigration;
import com.ekate.backend.repository.AdminRepositoryInterface;
import com.ekate.backend.repository.UserRepositoryInterface;
import com.ekate.backend.repository.impl.AdminRepositoryImpl;
import com.ekate.backend.repository.impl.UserRepositoryImpl;
import com.ekate.backend.security.JwtUtil;
import com.ekate.backend.service.AdminService;
import com.ekate.backend.service.DBService;
import com.ekate.backend.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


    @Configuration
    public class ServiceConfiguration {
    @Bean
    public AdminRepositoryInterface adminRepository(DBService dbService){
        return new AdminRepositoryImpl(dbService);
    }

    @Bean
    public UserRepositoryInterface userRepository(DBService dbService){
        return new UserRepositoryImpl(dbService);
    }

    @Bean
    public AdminService adminService(AdminRepositoryInterface adminRepository){
        return new AdminService(adminRepository);
    }
    @Bean
    public EmployeeService employeeService(UserRepositoryInterface userRepository, JwtUtil jwtUtil){
        return new EmployeeService(userRepository,jwtUtil);
    }





}

