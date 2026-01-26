package com.ekate.backend.service;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.repository.AdminRepositoryInterface;
import com.ekate.backend.repository.impl.AdminRepositoryImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class AdminService  {
    private final AdminRepositoryInterface adminRepository;

    public AdminService( AdminRepositoryInterface adminRepository) {
        this.adminRepository = adminRepository;
    }
    public String saveOrganisation(Organisation organisation) {
        return adminRepository.saveOrganisation(organisation);
    }
    public String saveUnit(Unit unit) {
        return adminRepository.saveUnit(unit);
    }
}
