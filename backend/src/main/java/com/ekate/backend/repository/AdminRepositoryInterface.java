package com.ekate.backend.repository;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public interface AdminRepositoryInterface {

   String saveOrganisation(Organisation organisation, JdbcTemplate jdbc);
   String saveUnit(Unit unit,JdbcTemplate jdbc);
}
