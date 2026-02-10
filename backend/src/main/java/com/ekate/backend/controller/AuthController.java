package com.ekate.backend.controller;

import com.ekate.backend.entity.request.AuthRequest;
import com.ekate.backend.entity.response.AuthResponse;
import com.ekate.backend.entity.response.PostResponse;
import com.ekate.backend.error.BadRequestException;
import com.ekate.backend.security.JwtUtil;
import com.ekate.backend.service.DBService;
import com.ekate.backend.service.EmployeeService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
@PermitAll
@RequestMapping("api/auth")
public class AuthController {
    private final EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) throws SQLException, BadRequestException {
        String token = employeeService.loginUser(request);
        if (token.isEmpty()){
            throw new BadRequestException("Не верено введен email или пароль");
        }
        else {
            return ResponseEntity.ok().body(new AuthResponse(token));
        }
    }
}
