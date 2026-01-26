package com.ekate.backend.repository.impl;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.repository.AdminRepositoryInterface;
import com.ekate.backend.repository.queries.Queries;
import com.ekate.backend.service.DBService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AdminRepositoryImpl implements AdminRepositoryInterface {

    private final DBService dbService;

    public AdminRepositoryImpl(DBService dbService) {
        this.dbService = dbService;

    }

    @Override
    public String saveOrganisation(Organisation organisation) {
        JdbcTemplate jdbc = dbService.jdbcTemplate;
        String uuid = UUID.randomUUID().toString();
        try {
            jdbc.update(Queries.createOrganisationQuery,
                    uuid,
                    organisation.getOrganisation_name() ,
                    organisation.isSetup_complete());
            return "Добавление организации: Успешно";
        }catch (Exception e){
            return e.toString();
        }
    }

    @Override
    public String saveUnit(Unit unit) {
        JdbcTemplate jdbc = dbService.jdbcTemplate;
        String uuid = UUID.randomUUID().toString();
        try{
            jdbc.update(Queries.createUnit,
                    unit.getOrganisation_name(),
                    uuid,
                    unit.getUnit_name());
            return "Добавление отдела: Успешно";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
