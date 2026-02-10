package com.ekate.backend.repository;

import com.ekate.backend.entity.Employee;
import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.entity.request.CreateEmployeeRequest;
import com.ekate.backend.error.BadRequestException;

import java.sql.SQLException;

public interface AdminRepositoryInterface {
   void saveOrganisation(Organisation organisation) throws BadRequestException;
   void saveUnit(Unit unit) throws BadRequestException;
   void createEmployee(CreateEmployeeRequest employeeRequest,String password) throws BadRequestException;
}
