package com.ekate.backend.service;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.repository.impl.AdminRepositoryImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class AdminService  {
    private final DBService dbService;
    private final AdminRepositoryImpl adminRepositoryImpl;

    public AdminService(DBService dbService,  AdminRepositoryImpl adminRepositoryImpl) {
        this.dbService = dbService;
        this.adminRepositoryImpl = adminRepositoryImpl;
    }

    public String saveOrganisation(Organisation organisation) {
        JdbcTemplate db = dbService.jdbc();
        return adminRepositoryImpl.saveOrganisation(organisation,db);
    }

    public String saveUnit(Unit unit) {
        JdbcTemplate db = dbService.jdbc();
        return adminRepositoryImpl.saveUnit(unit,db);
    }
}
