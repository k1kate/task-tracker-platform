package com.ekate.backend.controller;
import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.response.PostResponse;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.service.AdminService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor

@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;


    @PostMapping("/create/organisation")
    public ResponseEntity<PostResponse> CreateOrganisation(@RequestBody Organisation organisation) throws SQLException {
        adminService.saveOrganisation(organisation);
        return ResponseEntity.ok().body(new PostResponse(
                    true,"Добавление организации: Успешно"));

    }

    @PostMapping("/create/unit")
    public ResponseEntity<PostResponse> CreateUnit(@RequestBody Unit unit) throws SQLException {
         adminService.saveUnit(unit);
         return ResponseEntity.ok().body(new PostResponse(
                    true,"Добавление отдела: Успешно"));

    }

}
