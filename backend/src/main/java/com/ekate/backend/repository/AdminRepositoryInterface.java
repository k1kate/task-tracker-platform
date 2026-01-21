package com.ekate.backend.repository;

import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryInterface {
    public String saveOrganisation(Organisation organisation);
    public String saveUnit(Unit unit);
}
