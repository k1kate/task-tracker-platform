package com.ekate.backend.controller;
import com.ekate.backend.entity.Organisation;
import com.ekate.backend.entity.PostResponse;
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
@PermitAll
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/create/organisation")
    public ResponseEntity<PostResponse> CreateOrganisation(@RequestBody Organisation organisation){
        String result = adminService.saveOrganisation(organisation);

        if(!result.equals("Добавление организации: Успешно")){
            return ResponseEntity.badRequest().body(new PostResponse(
                    false,result));
        }
        else{
            return ResponseEntity.badRequest().body(new PostResponse(
                    true,"Добавление организации: Успешно"));
        }

    }

}
