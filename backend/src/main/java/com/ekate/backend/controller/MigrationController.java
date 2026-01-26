package com.ekate.backend.controller;

import com.ekate.backend.entity.DatabaseMigration;
import com.ekate.backend.entity.response.PostResponse;
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
        String url,user,password;
        url = db.getUrl();
        user = db.getUser();
        password = db.getPassword();

        if(url.isEmpty() || user.isEmpty() || password.isEmpty()){
            return ResponseEntity.badRequest().body(
                    new PostResponse(false, "Ошибка в миграции, введите верные данные")
            );
        }

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
               return ResponseEntity.badRequest().body(
                       new PostResponse(false, "Ошибка в миграции, Попробуйте заново")
               );
           }
    }

}
