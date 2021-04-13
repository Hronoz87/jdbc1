package ru.netology.jdbc2;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String joinJdbc = read();

    private static String read() {
        try (InputStream is = new ClassPathResource("join.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String product_name) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from customers");
         if (sqlRowSet.getObject(customers.name)) {
             return product_name;
         }
        return jdbcTemplate.queryForObject(joinJdbc, String.class);
    }

}
