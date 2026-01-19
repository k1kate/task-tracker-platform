package com.ekate.backend.repository;

import com.ekate.backend.entity.Organisation;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryInterface {
    public String saveOrganisation(Organisation organisation);
}
