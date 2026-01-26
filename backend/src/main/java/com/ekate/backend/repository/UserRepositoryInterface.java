package com.ekate.backend.repository;

import com.ekate.backend.entity.Employee;
import com.ekate.backend.entity.request.AuthRequest;
import org.springframework.jdbc.core.JdbcTemplate;

public interface UserRepositoryInterface {
      Employee GetEmployeeByEmail(AuthRequest authRequest);
}
