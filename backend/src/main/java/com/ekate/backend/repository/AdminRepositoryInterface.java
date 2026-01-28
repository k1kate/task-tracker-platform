package com.ekate.backend.repository;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

public interface AdminRepositoryInterface {
   String saveOrganisation(Organisation organisation) throws SQLException;
   String saveUnit(Unit unit) throws SQLException;
}
