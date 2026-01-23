package com.ekate.backend.controller;

import com.ekate.backend.entity.DatabaseMigration;
import com.ekate.backend.entity.PostResponse;
import com.ekate.backend.service.DBService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PostResponse> migrate(@RequestBody DatabaseMigration db)
            throws IOException
    {
           boolean result = DBService.migrate(db);
           if(result){
               Files.writeString(
                       Path.of("db-config.json"),
                       new ObjectMapper().writeValueAsString(db)
               );
               return ResponseEntity.ok().body(new PostResponse(
                       true,"Миграция выполнена успешно"));

           }
           else {
               return ResponseEntity.ok().body(
                       new PostResponse(false, "Ошибка в миграции, Попробуйте заново")
               );
           }
    }

}
