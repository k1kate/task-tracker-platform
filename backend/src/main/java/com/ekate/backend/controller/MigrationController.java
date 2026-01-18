package com.ekate.backend.controller;

import com.ekate.backend.entity.Database_migration;
import com.ekate.backend.entity.Database_migration_response;
import com.ekate.backend.service.DBService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequiredArgsConstructor
@PermitAll
@RequestMapping("/api/database")
public class MigrationController {

    private final DBService DBService;
    @PostMapping("/migration")
    @ResponseBody
    public ResponseEntity<Database_migration_response> migrate(@RequestBody Database_migration db)
            throws IOException
    {

           boolean result = DBService.migrate(db);
           if(result){
               Files.writeString(
                       Path.of("db-config.json"),
                       new ObjectMapper().writeValueAsString(db)
               );
               return ResponseEntity.ok().body(new Database_migration_response(
                       true,"Миграция выполнена успешно"));

           }
           else {
               return  ResponseEntity.internalServerError().body(new Database_migration_response(
                       false,"Ошибка в миграции, Попробуйте заново"));
           }
    }

}
