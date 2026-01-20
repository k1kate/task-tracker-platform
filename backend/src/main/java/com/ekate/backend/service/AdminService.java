package com.ekate.backend.service;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.repository.AdminRepositoryInterface;
import com.ekate.backend.repository.queries.Queries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AdminService implements AdminRepositoryInterface {
    private final DBService dbService;

    public AdminService(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public String saveOrganisation(Organisation organisation) {
        JdbcTemplate db = dbService.jdbc();
        String uuid = UUID.randomUUID().toString();
        try {
            db.update(Queries.createOrganisationQuery,
                    uuid,
                    organisation.getOrganisation_name() ,
                    organisation.isSetup_complete());
            return "Добавление организации: Успешно";
        }catch (Exception e){
            return e.toString();
        }
    }
}
