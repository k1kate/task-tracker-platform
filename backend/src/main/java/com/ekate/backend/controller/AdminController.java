package com.ekate.backend.controller;
import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.response.PostResponse;
import com.ekate.backend.entity.Unit;
import com.ekate.backend.service.AdminService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor

@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @PermitAll
    @PostMapping("/create/organisation")
    public ResponseEntity<PostResponse> CreateOrganisation(@RequestBody Organisation organisation){
        String result = adminService.saveOrganisation(organisation);

        if(!result.equals("Добавление организации: Успешно")){
            return ResponseEntity.badRequest().body(new PostResponse(
                    false,result));
        }
        else{
            return ResponseEntity.ok().body(new PostResponse(
                    true,"Добавление организации: Успешно"));
        }
    }
    @PermitAll
    @PostMapping("/create/unit")
    public ResponseEntity<PostResponse> CreateUnit(@RequestBody Unit unit){
        String result = adminService.saveUnit(unit);
        if(!result.equals("Добавление отдела: Успешно")){
            return ResponseEntity.badRequest().body(new PostResponse(
                    false,result));
        }
        else{
            return ResponseEntity.ok().body(new PostResponse(
                    true,"Добавление отдела: Успешно"));
        }
    }

}
