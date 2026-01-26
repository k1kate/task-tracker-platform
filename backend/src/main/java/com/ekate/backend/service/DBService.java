package com.ekate.backend.service;
import com.ekate.backend.entity.DatabaseMigration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Service
public class DBService {

    public volatile JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public DBService() {
        this.objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void init(){
        Path path = Path.of("db-config.json");
        if (Files.exists(path)) {
            try {
                DatabaseMigration db = objectMapper.readValue(
                        path.toFile(),
                        DatabaseMigration.class
                );
                migrate(db);
            } catch (Exception e) {
                log.error("Ошибка инициализации БД", e);
            }
        }
    }

    public synchronized boolean migrate(DatabaseMigration db) {
        if (jdbcTemplate != null) {
            return true;
        }
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(db.getUrl());
        ds.setUsername(db.getUser());
        ds.setPassword(db.getPassword());
        ds.setMaximumPoolSize(5);
        try(Connection conn = ds.getConnection()){
                if(!conn.isClosed()) {
                    Flyway flyway = Flyway.configure()
                            .dataSource(ds)
                            .load();
                    MigrateResult result = flyway.migrate();

                    this.jdbcTemplate = new JdbcTemplate(ds);
                    return result.success;
                }
        } catch (SQLException e) {
            log.error("Ошибка подключения к базе" ,e);
            return false;
        } catch (Exception e) {
            log.error("Ошибка миграции",e);
            return false;
        }
        return false;
    }

}
