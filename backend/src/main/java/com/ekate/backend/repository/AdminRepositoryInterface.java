package com.ekate.backend.repository;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public interface AdminRepositoryInterface {
   String saveOrganisation(Organisation organisation);
   String saveUnit(Unit unit);
}
