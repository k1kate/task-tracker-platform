package com.ekate.backend.service;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.entity.request.CreateEmployeeRequest;
import com.ekate.backend.error.BadRequestException;
import com.ekate.backend.repository.AdminRepositoryInterface;
import com.ekate.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class AdminService  {
    private final AdminRepositoryInterface adminRepository;

    @Autowired
    private EmailService emailService;
    @Autowired
    private EmployeeService employeeService;

    public AdminService(AdminRepositoryInterface adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void saveOrganisation(Organisation organisation) throws BadRequestException {
        adminRepository.saveOrganisation(organisation);
    }
    public void saveUnit(Unit unit) throws  BadRequestException {
        adminRepository.saveUnit(unit);
    }
    public void saveEmployee(CreateEmployeeRequest employeeRequest) throws  BadRequestException {

        String generatedPassword = CreateRandomString();
        String hashedPassword = employeeService.hashPassword(generatedPassword);

        adminRepository.createEmployee(employeeRequest,hashedPassword);
        emailService.SendPasswordToEmail(employeeRequest.getEmail(),generatedPassword);
    }

    public String CreateRandomString(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        return  random.ints(6,0,chars.length())
                .mapToObj(chars::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
