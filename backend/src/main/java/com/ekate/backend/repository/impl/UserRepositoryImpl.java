package com.ekate.backend.repository.impl;

import com.ekate.backend.entity.Employee;
import com.ekate.backend.entity.request.AuthRequest;
import com.ekate.backend.repository.UserRepositoryInterface;
import com.ekate.backend.repository.queries.Queries;
import com.ekate.backend.service.DBService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepositoryInterface {
    private  final DBService dbService;

    public UserRepositoryImpl(DBService dbService) {
        this.dbService = dbService;

    }

    @Override
    public Employee GetEmployeeByEmail(AuthRequest authRequest) throws SQLException {
        JdbcTemplate jdbc = dbService.jdbcTemplate;

        RowMapper<Employee> rowMapper = (rs,rowNum) ->{
                Employee employee = new Employee();
                employee.setUuid(rs.getString("uuid"));
                employee.setName(rs.getString("name"));
                employee.setSecondName(rs.getString("second_name"));
                employee.setPatronymic(rs.getString("patronymic"));
                employee.setEmployeeSpringTimeCapacity(String.valueOf(rs.getTime("employee_sprint_time_capacity")));
                employee.setAvatar(rs.getString("avatar"));
                employee.setEmail(rs.getString("email"));
                employee.setUnitName(rs.getString("unit_name"));
                employee.setPassword(rs.getString("password"));
                employee.setAdmin(rs.getBoolean("is_admin"));
                return  employee;
        };
        return jdbc.queryForObject(Queries.getByEmail,rowMapper,authRequest.getEmail());


    }
}
