package com.ekate.backend;

import com.ekate.backend.entity.DatabaseMigration;
import com.ekate.backend.service.DBService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@SpringBootApplication
public class BackendApplication {

	private final DBService DBService;
	private final ObjectMapper objectMapper;


	public BackendApplication(DBService DBService, ObjectMapper objectMapper) {
		this.DBService = DBService;
        this.objectMapper = objectMapper;
    }

	@EventListener(ApplicationReadyEvent.class)
	public void AutoInit()  {
		Path path = Path.of("db-config.json");

		if(Files.exists(path)){
			try {
				DatabaseMigration db = objectMapper.readValue(path.toFile(),
						DatabaseMigration.class);
				DBService.migrate(db);
			}

			catch (Exception e){
				log.error("Ошбика инициализации бд",e);
			}
		}

	}
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
