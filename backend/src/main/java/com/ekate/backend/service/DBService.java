package com.ekate.backend.service;
import com.ekate.backend.entity.DatabaseMigration;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DBService {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public synchronized boolean migrate(DatabaseMigration db) {
        if (this.dataSource != null) {
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

                    this.dataSource =ds;
                    this.jdbcTemplate = new JdbcTemplate(dataSource);

                    return result.success;
                }
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе: " + e.getMessage());
            return false; // Возвращаем false вместо RuntimeException
        } catch (Exception e) {
            System.err.println("Ошибка миграции: " + e.getMessage());
            return false;
        }
        return false;
    }

    //Будем вызывать для того чтобы получить коннект к бд и делать запросы
    public JdbcTemplate jdbc() {
        if (jdbcTemplate == null) {
            throw new IllegalStateException("DB not initialized");
        }
        return jdbcTemplate;
    }


}
