package com.ekate.backend.repository.impl;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.entity.request.CreateEmployeeRequest;
import com.ekate.backend.error.BadRequestException;
import com.ekate.backend.repository.AdminRepositoryInterface;
import com.ekate.backend.repository.queries.Queries;
import com.ekate.backend.service.DBService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.UUID;

@Repository
public class AdminRepositoryImpl implements AdminRepositoryInterface {
    private final DBService dbService;

    public AdminRepositoryImpl(DBService dbService) {
        this.dbService = dbService;

    }

    @Override
    public void saveOrganisation(Organisation organisation) throws  BadRequestException {

        JdbcTemplate jdbc = dbService.jdbcTemplate;
        String uuid = UUID.randomUUID().toString();
        int update = jdbc.update(Queries.createOrganisationQuery,
                    uuid,
                    organisation.getOrganisation_name() ,
                    organisation.isSetup_complete());

        if (update == 0){
            throw new BadRequestException("Не верные данные для создания организации");
        }
    }

    @Override
    public void saveUnit(Unit unit) throws BadRequestException {

        JdbcTemplate jdbc = dbService.jdbcTemplate;
        String uuid = UUID.randomUUID().toString();

        int update = jdbc.update(Queries.createUnit,
                    unit.getOrganisation_name(),
                    uuid,
                    unit.getUnit_name());

        if(update == 0){
            throw new BadRequestException("Не верные данные для создания отдела");
        }
    }

    @Override
    public void createEmployee(CreateEmployeeRequest employeeRequest,String password) throws  BadRequestException {

        JdbcTemplate jdbc = dbService.jdbcTemplate;
        String uuid = UUID.randomUUID().toString();
        int update = jdbc.update(Queries.createEmployee,
                employeeRequest.getUnitName(),
                uuid,
                employeeRequest.getName(),
                employeeRequest.getSecondName(),
                employeeRequest.getPatronymic(),
                password,
                employeeRequest.getEmail()
        );
        if(update == 0){
            throw new BadRequestException("Не верные данные для создания учетной записи сотрудника");
        }
    }
}
