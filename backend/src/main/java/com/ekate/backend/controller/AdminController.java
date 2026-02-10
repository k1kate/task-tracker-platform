package com.ekate.backend.controller;
import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.request.CreateEmployeeRequest;
import com.ekate.backend.entity.response.PostResponse;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.error.BadRequestException;
import com.ekate.backend.error.ForbiddenException;
import com.ekate.backend.service.AdminService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor

@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/create/organisation")
    public ResponseEntity<PostResponse> CreateOrganisation(@RequestBody Organisation organisation)
            throws  ForbiddenException, BadRequestException {
        boolean isAdmin = checkIsAdmin();
        if(!isAdmin){
                throw  new ForbiddenException("Пользователь не админ");
        }

        adminService.saveOrganisation(organisation);

        return ResponseEntity.ok().body(new PostResponse(
                    true,"Добавление организации: Успешно"));

    }

    @PostMapping("/create/unit")
    public ResponseEntity<PostResponse> CreateUnit(@RequestBody Unit unit)
            throws ForbiddenException, BadRequestException {
        boolean isAdmin = checkIsAdmin();
        if(!isAdmin){
            throw  new ForbiddenException("Пользователь не админ");
        }
         adminService.saveUnit(unit);
         return ResponseEntity.ok().body(new PostResponse(
                    true,"Добавление отдела: Успешно"));

    }

    @PostMapping("/create/employee")
    public ResponseEntity<PostResponse> CreateEmployee(@RequestBody CreateEmployeeRequest employeeRequest)
            throws  ForbiddenException, BadRequestException {
        boolean isAdmin = checkIsAdmin();
        if(!isAdmin){
            throw  new ForbiddenException("Пользователь не админ");
        }
        adminService.saveEmployee(employeeRequest);
        return ResponseEntity.ok().body(new PostResponse(
                true,"Добавление сотрудника: Успешно"
        ));
    }


    public boolean checkIsAdmin(){
        var context = SecurityContextHolder.getContext();
        Object principal =  context.getAuthentication().getPrincipal();
        boolean isAdmin = false;
        if(principal instanceof Map<?, ?> claims){
            isAdmin = (boolean) claims.get("isAdmin");
        }
        System.out.println(isAdmin);
        return isAdmin;
    }

}
